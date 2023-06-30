package ru.test.java.planflight.web.dto.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.test.java.planflight.web.dto.simple.EmployeeDto;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class EmployeesBatchDto extends BatchDto {

    @JsonProperty("Fleets")
    private List<String> fleets;

    @JsonProperty("Employees")
    private List<EmployeeDto> employees;
}
