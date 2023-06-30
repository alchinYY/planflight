package ru.test.java.planflight.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.test.java.planflight.model.Employee;

@Service
public class EmployeeDbService extends PlanFlightDbService<Employee, Long> {

    public EmployeeDbService(JpaRepository<Employee, Long> repository) {
        super(Employee.class, repository);
    }

}
