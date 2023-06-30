package ru.test.java.planflight.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.model.Pairing;
import ru.test.java.planflight.web.dto.simple.PairingDto;

@Component
public class PairingEntityToDtoConverter extends AbstractConverter<Pairing, PairingDto> {

    @Override
    protected PairingDto convert(Pairing source) {
    

        return PairingDto.builder()
                .id(source.getId())
                .endTime(source.getEndTime())
                .startTime(source.getStartTime())
                .type(source.getType())
                .fleet(source.getFleet().getName())
                .build();
    }

}
