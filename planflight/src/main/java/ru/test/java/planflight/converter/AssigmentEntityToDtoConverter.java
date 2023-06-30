package ru.test.java.planflight.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.model.Assignment;
import ru.test.java.planflight.web.dto.simple.AssigmentDto;

@Component
public class AssigmentEntityToDtoConverter extends AbstractConverter<Assignment, AssigmentDto> {

    @Override
    protected AssigmentDto convert(Assignment source) {
        return AssigmentDto.builder()
                .employeeID(source.getEmployee().getId())
                .pairingID(source.getPairing().getId())
                .rank(source.getRank())
                .build();
    }

}
