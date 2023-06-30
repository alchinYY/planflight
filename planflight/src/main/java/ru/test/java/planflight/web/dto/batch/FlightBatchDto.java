package ru.test.java.planflight.web.dto.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.test.java.planflight.web.dto.simple.FlightDto;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class FlightBatchDto extends BatchDto {

    @JsonProperty("Flights")
    private List<FlightDto> flights;

}
