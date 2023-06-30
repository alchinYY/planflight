package ru.test.java.planflight.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.model.Pairing;
import ru.test.java.planflight.repository.PairingRepo;
import ru.test.java.planflight.service.EmployeeFilterSearcherService;

import java.util.List;

@Service
public class PairingDbService extends PlanFlightDbService<Pairing, Long>
        implements EmployeeFilterSearcherService<Pairing> {

    private final PairingRepo repository;

    public PairingDbService(PairingRepo repository) {
        super(Pairing.class, repository);
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pairing> findByEmployee(Employee employee) {
        System.out.println(employee);
        return repository.findAllByEmployee(employee);
    }
}
