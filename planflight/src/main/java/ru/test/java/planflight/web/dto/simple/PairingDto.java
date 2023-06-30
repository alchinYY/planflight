package ru.test.java.planflight.web.dto.simple;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.test.java.planflight.web.dto.PlanFlightDto;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PairingDto implements PlanFlightDto {
    @JsonProperty(value = "ID")
    private Long id;

    @JsonProperty(value = "Fleet")
    private String fleet;

    @JsonProperty(value = "DateTimeEnd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm z")
    private ZonedDateTime endTime;

    @JsonProperty(value = "DateTimeStart")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm z")
    private ZonedDateTime startTime;

    @JsonProperty(value = "TypePairing")
    private String type;
}