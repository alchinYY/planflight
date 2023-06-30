package ru.test.java.planflight.web.dto.simple;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.test.java.planflight.web.dto.PlanFlightDto;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AssigmentDto implements PlanFlightDto {

    @JsonProperty("Rank")
    private String rank;

    @JsonProperty("EmployeeID")
    private Long employeeID;

    @JsonProperty("PairingID")
    private Long pairingID;
}