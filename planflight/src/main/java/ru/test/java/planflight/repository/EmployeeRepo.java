package ru.test.java.planflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.java.planflight.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
