package ru.test.java.planflight.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fleets")
@Data
@EqualsAndHashCode(of = "id")
public class Fleet implements PlanFlightEntity {

    @Id
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Override
    public String toString(){
        return name;
    }
}
