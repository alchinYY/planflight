package ru.test.java.planflight.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "flights")
@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight implements PlanFlightEntity {

    @Id
    private long id;

    @Column(name = "number", unique = true)
    private String number;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Column(name = "departure_time")
    private ZonedDateTime departureTime;

    @Column(name = "arrival_time")
    private ZonedDateTime arrivalTime;

}
