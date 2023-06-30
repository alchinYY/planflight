package ru.test.java.planflight.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.model.Flight;
import ru.test.java.planflight.repository.FlightRepo;
import ru.test.java.planflight.service.EmployeeFilterSearcherService;

import java.util.List;

@Service
public class FlightDbService extends PlanFlightDbService<Flight, Long>
        implements EmployeeFilterSearcherService<Flight> {

    private final FlightRepo flightRepo;

    public FlightDbService(FlightRepo repository) {
        super(Flight.class, repository);
        this.flightRepo = repository;
    }

    @Override
    public List<Flight> findByEmployee(Employee employee) {
        return null;
    }
}
