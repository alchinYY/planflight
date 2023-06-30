package ru.test.java.planflight.web.dto.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BatchDto {

    @JsonProperty("Caption")
    private String caption;

    @JsonProperty("Created")
    private String Created;

    @JsonProperty("Division")
    private String division;

    @JsonProperty("Version")
    private String version;

}
