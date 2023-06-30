package ru.test.java.planflight.service;

import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.model.PlanFlightEntity;

import java.util.List;

public interface EmployeeFilterSearcherService<T extends PlanFlightEntity> {

    List<T> findByEmployee(Employee employee);

}
