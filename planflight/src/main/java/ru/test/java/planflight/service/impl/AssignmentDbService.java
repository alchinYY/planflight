package ru.test.java.planflight.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.test.java.planflight.model.Assignment;

@Service
public class AssignmentDbService extends PlanFlightDbService<Assignment, Long> {

    public AssignmentDbService(JpaRepository<Assignment, Long> repository) {
        super(Assignment.class, repository);
    }

}
