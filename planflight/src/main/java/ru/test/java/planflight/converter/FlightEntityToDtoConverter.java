package ru.test.java.planflight.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.model.Flight;
import ru.test.java.planflight.web.dto.simple.FlightDto;

@Component
public class FlightEntityToDtoConverter extends AbstractConverter<Flight, FlightDto> {

    @Override
    protected FlightDto convert(Flight source) {

        return FlightDto.builder()
                .id(source.getId())
                .number(source.getNumber())
                .arrivalAirport(source.getArrivalAirport())
                .departureAirport(source.getDepartureAirport())
                .arrivalTime(source.getArrivalTime())
                .departureTime(source.getDepartureTime())
                .build();
    }

}
