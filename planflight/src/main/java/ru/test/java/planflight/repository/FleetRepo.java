package ru.test.java.planflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.java.planflight.model.Fleet;

import java.util.List;
import java.util.Optional;

@Repository
public interface FleetRepo extends JpaRepository<Fleet, Long> {

    List<Fleet> findAllByNameIsIn(List<String> names);

    Optional<Fleet> findByName(String names);

}
