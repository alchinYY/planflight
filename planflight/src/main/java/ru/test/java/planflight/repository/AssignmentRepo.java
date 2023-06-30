package ru.test.java.planflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.java.planflight.model.Assignment;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment, Long> {
}
