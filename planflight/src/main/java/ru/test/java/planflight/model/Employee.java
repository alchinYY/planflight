package ru.test.java.planflight.model;

import lombok.*;
import ru.test.java.planflight.model.enumerate.Gender;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements PlanFlightEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="employee_fleets",
            joinColumns = @JoinColumn( name="employee_id"),
            inverseJoinColumns = @JoinColumn( name="fleets_id")
    )
    private List<Fleet> fleets;

}
