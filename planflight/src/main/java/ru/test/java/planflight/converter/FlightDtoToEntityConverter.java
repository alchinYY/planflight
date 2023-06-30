package ru.test.java.planflight.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.model.Flight;
import ru.test.java.planflight.web.dto.simple.FlightDto;

@Component
@RequiredArgsConstructor
public class FlightDtoToEntityConverter extends AbstractConverter<FlightDto, Flight> {


    @Override
    protected Flight convert(FlightDto dto) {
        return Flight.builder()
                .id(dto.getId())
                .arrivalAirport(dto.getArrivalAirport())
                .departureAirport(dto.getDepartureAirport())
                .number(dto.getNumber())
                .departureTime(dto.getDepartureTime())
                .arrivalTime(dto.getArrivalTime())
                .build();
    }

}
