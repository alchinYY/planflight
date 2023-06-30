package ru.test.java.planflight.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.test.java.planflight.helper.ModelMapperHelper;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.service.impl.EmployeeDbService;
import ru.test.java.planflight.web.dto.simple.EmployeeDto;

@RestController
@RequestMapping("/emplyee")
@RequiredArgsConstructor
public class EmployeeController {

    private final ModelMapperHelper mapper;
    private final EmployeeDbService employeeDbService;

    @GetMapping("{id}")
    @Operation(summary = "Получить по id")
    public EmployeeDto getById(@PathVariable(name = "id") Long id) {
        return mapper.map(employeeDbService.getById(id), EmployeeDto.class);
    }

    @PostMapping
    @Operation(summary = "Сохранить сотрудника")
    public EmployeeDto upload(@RequestBody EmployeeDto employee) {
        var entity = employeeDbService.upload(mapper.map(employee, Employee.class));
        return mapper.map(entity, EmployeeDto.class);
    }


}
