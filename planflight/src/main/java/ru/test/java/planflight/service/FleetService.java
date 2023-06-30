package ru.test.java.planflight.service;

import ru.test.java.planflight.model.Fleet;

import java.util.List;

public interface FleetService {

    List<Fleet> findByNamesInList(List<String> names);
    Fleet findByNames(String name);

}
