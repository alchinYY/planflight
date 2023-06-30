package ru.test.java.planflight.web.dto.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.test.java.planflight.web.dto.simple.AssigmentDto;
import ru.test.java.planflight.web.dto.simple.PairingDto;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RosterBatchDto extends BatchDto {

    @JsonProperty("Assignments")
    private List<AssigmentDto> assignments;

    @JsonProperty("Pairings")
    private List<PairingDto> pairings;
}
