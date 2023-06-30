package ru.test.java.planflight.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.test.java.planflight.helper.FileHelper;
import ru.test.java.planflight.helper.MapperHelper;
import ru.test.java.planflight.model.Assignment;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.model.Flight;
import ru.test.java.planflight.model.Pairing;
import ru.test.java.planflight.service.PlanFlightService;
import ru.test.java.planflight.web.dto.batch.EmployeesBatchDto;
import ru.test.java.planflight.web.dto.batch.FlightBatchDto;
import ru.test.java.planflight.web.dto.batch.RosterBatchDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/migration")
public class MigrationController {

    private final FileHelper fileHelper;
    private final MapperHelper mapper;
    private final PlanFlightService<Flight, Long> flightService;
    private final PlanFlightService<Employee, Long> employeeService;
    private final PlanFlightService<Pairing, Long> pairingService;
    private final PlanFlightService<Assignment, Long> assignmentService;


    @PostMapping(value = "employees", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "Сохранить сотрудников")
    public void uploadEmployees(@RequestPart MultipartFile file) {
        var fileWithData = fileHelper.saveFile(file);
        var employeesList = mapper.mapAll(
                fileHelper.parse(fileWithData, EmployeesBatchDto.class).getEmployees(),
                Employee.class
        );
        employeeService.upload(employeesList);
    }

    @PostMapping(value = "flights", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "Сохранить полеты")
    public void uploadFlights(@RequestPart MultipartFile file) {
        var fileWithData = fileHelper.saveFile(file);
        var flights = mapper.mapAll(
                fileHelper.parse(fileWithData, FlightBatchDto.class).getFlights(),
                Flight.class
        );
        flightService.upload(flights);
    }

    @PostMapping(value = "roster", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "Сохранить пэйринги и назначения")
    public void uploadPairingsAndAssignments(@RequestPart MultipartFile file) {
        var fileWithData = fileHelper.saveFile(file);
        var rosterBatchDto = fileHelper.parse(fileWithData, RosterBatchDto.class);
        var pairings = mapper.mapAll(rosterBatchDto.getPairings(), Pairing.class);
        pairingService.upload(pairings);

        var assignments = mapper.mapAll(rosterBatchDto.getAssignments(), Assignment.class);
        assignmentService.upload(assignments);
    }
}
