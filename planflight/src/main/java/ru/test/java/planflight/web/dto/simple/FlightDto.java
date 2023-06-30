package ru.test.java.planflight.web.dto.simple;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.test.java.planflight.web.dto.PlanFlightDto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class FlightDto implements PlanFlightDto {

    @JsonProperty(value = "ID")
    private Long id;

    @JsonProperty(value = "FlightNum")
    private String number;

    @JsonProperty(value = "StationDeparture")
    private String departureAirport;

    @JsonProperty(value = "StationArrival")
    private String arrivalAirport;

    @JsonProperty(value = "DateTimeDeparture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm z")
    private ZonedDateTime departureTime;

    @JsonProperty(value = "DateTimeArrival")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm z")
    private ZonedDateTime arrivalTime;
}
