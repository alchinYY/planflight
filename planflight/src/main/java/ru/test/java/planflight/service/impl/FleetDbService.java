package ru.test.java.planflight.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.java.planflight.exception.NotFoundException;
import ru.test.java.planflight.model.Fleet;
import ru.test.java.planflight.repository.FleetRepo;
import ru.test.java.planflight.service.FleetService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FleetDbService implements FleetService {

    private final FleetRepo fleetRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Fleet> findByNamesInList(List<String> names) {
        var fleets = fleetRepo.findAllByNameIsIn(names);

        if(fleets.size() < names.size()) {
            throw new NotFoundException("Fleets with names %s not found", names);
        }

        return fleets;
    }

    @Override
    @Transactional(readOnly = true)
    public Fleet findByNames(String name) {
        return fleetRepo.findByName(name)
                .orElseThrow(() -> new NotFoundException("Fleets with name %s not found", name));
    }
}
