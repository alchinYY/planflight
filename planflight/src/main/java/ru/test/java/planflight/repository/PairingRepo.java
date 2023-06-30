package ru.test.java.planflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.model.Pairing;

import java.util.List;

@Repository
public interface PairingRepo extends JpaRepository<Pairing, Long> {

    @Query("select a.pairing from Assignment a " +
            "join a.pairing " +
            "join a.employee " +
            "where a.employee = :employee")
    List<Pairing> findAllByEmployee(@Param("employee") Employee employee);

}
