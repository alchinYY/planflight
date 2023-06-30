package ru.test.java.planflight.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "pairings")
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Pairing implements PlanFlightEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "type_pairing")
    private String type;

    @JoinColumn(name = "fleet_id")
    @ManyToOne
    private Fleet fleet;

    @Column(name = "start_time")
    private ZonedDateTime startTime;

    @Column(name = "end_time")
    private ZonedDateTime endTime;
}
