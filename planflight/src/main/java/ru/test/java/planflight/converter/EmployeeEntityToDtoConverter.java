package ru.test.java.planflight.converter;

import org.apache.logging.log4j.util.Strings;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.web.dto.simple.EmployeeDto;

@Component
public class EmployeeEntityToDtoConverter extends AbstractConverter<Employee, EmployeeDto> {

    @Override
    protected EmployeeDto convert(Employee source) {
    
        var fleetString = Strings.join(source.getFleets(), '_');

        return EmployeeDto.builder()
                .id(source.getId())
                .gender(source.getGender().toString())
                .fleet(fleetString)
                .build();
    }

}
