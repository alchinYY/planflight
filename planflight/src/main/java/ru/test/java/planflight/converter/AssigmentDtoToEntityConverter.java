package ru.test.java.planflight.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.model.Assignment;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.model.Pairing;
import ru.test.java.planflight.service.PlanFlightService;
import ru.test.java.planflight.web.dto.simple.AssigmentDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AssigmentDtoToEntityConverter extends AbstractConverter<AssigmentDto, Assignment> {

    private final PlanFlightService<Employee, Long> employeeService;
    private final PlanFlightService<Pairing, Long> pairingService;

    @Override
    protected Assignment convert(AssigmentDto dto) {

        var pairing = Optional.ofNullable(dto.getPairingID())
                .map(pairingService::getById)
                .orElse(null);

        return Assignment.builder()
                .rank(dto.getRank())
                .pairing(pairing)
                .employee(employeeService.getById(dto.getEmployeeID()))
                .build();
    }
}
