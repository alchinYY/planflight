package ru.test.java.planflight.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.test.java.planflight.helper.MapperHelper;
import ru.test.java.planflight.model.Flight;
import ru.test.java.planflight.service.PlanFlightService;
import ru.test.java.planflight.web.dto.simple.EmployeeDto;
import ru.test.java.planflight.web.dto.simple.FlightDto;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final MapperHelper mapper;
    private final PlanFlightService<Flight, Long> flightService;


    @GetMapping("{id}")
    @Operation(summary = "Получить по id")
    public EmployeeDto getById(@PathVariable(name = "id") Long id) {
        return mapper.map(flightService.getById(id), EmployeeDto.class);
    }

    @PostMapping
    @Operation(summary = "Сохранить полет")
    public FlightDto upload(@RequestBody Flight flight) {
        var entity = flightService.upload(mapper.map(flight, Flight.class));
        return mapper.map(entity, FlightDto.class);
    }

}
