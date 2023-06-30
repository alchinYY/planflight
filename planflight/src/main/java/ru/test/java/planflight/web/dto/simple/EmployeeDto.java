package ru.test.java.planflight.web.dto.simple;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.test.java.planflight.web.dto.PlanFlightDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto implements PlanFlightDto {

    @JsonProperty(value = "ID")
    private Long id;

    @JsonProperty(value = "Gender")
    private String gender;

    @JsonProperty(value = "Fleet")
    private String fleet;
}
