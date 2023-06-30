package ru.test.java.planflight.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.model.Fleet;
import ru.test.java.planflight.model.enumerate.Gender;
import ru.test.java.planflight.service.FleetService;
import ru.test.java.planflight.web.dto.simple.EmployeeDto;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeDtoToEntityConverter extends AbstractConverter<EmployeeDto, Employee> {

    private final FleetService fleetService;

    @Override
    protected Employee convert(EmployeeDto dto) {
        List<Fleet> fleets = readFleets(dto);
        return Employee.builder()
                .id(dto.getId())
                .gender(Gender.valueOf(dto.getGender()))
                .fleets(fleets)
                .build();
    }

    private List<Fleet> readFleets(EmployeeDto dto) {
        return Optional.ofNullable(dto.getFleet())
                .map(f -> fleetService.findByNamesInList(
                        Arrays.stream(f.split("_"))
                                .distinct().collect(Collectors.toList())
                ))
                .orElse(Collections.emptyList());
    }
}
