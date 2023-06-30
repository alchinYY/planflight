package ru.test.java.planflight.service;

import ru.test.java.planflight.model.PlanFlightEntity;

import java.util.List;

public interface PlanFlightService<T extends PlanFlightEntity, ID extends Number> {

    T getById(ID id);

    List<T> upload(List<T> entities);

    T upload(T t);
}
