package ru.test.java.planflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.test.java.planflight.model.Flight;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

}
