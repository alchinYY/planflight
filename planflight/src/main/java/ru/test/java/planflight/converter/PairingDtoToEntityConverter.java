package ru.test.java.planflight.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.model.Pairing;
import ru.test.java.planflight.service.FleetService;
import ru.test.java.planflight.web.dto.simple.PairingDto;

@Component
@RequiredArgsConstructor
public class PairingDtoToEntityConverter extends AbstractConverter<PairingDto, Pairing> {

    private final FleetService fleetService;

    @Override
    protected Pairing convert(PairingDto dto) {
        return Pairing.builder()
                .id(dto.getId())
                .fleet(fleetService.findByNames(dto.getFleet()))
                .endTime(dto.getEndTime())
                .type(dto.getType())
                .startTime(dto.getStartTime())
                .build();
    }
}
