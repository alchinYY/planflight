package ru.test.java.planflight.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.java.planflight.helper.ModelMapperHelper;
import ru.test.java.planflight.service.impl.EmployeeDbService;
import ru.test.java.planflight.service.impl.PairingDbService;
import ru.test.java.planflight.web.dto.simple.PairingDto;

import java.util.List;

@RestController
@RequestMapping("pairing")
@RequiredArgsConstructor
public class PairingController {

    private final ModelMapperHelper mapper;
    private final EmployeeDbService employeeDbService;
    private final PairingDbService pairingDbService;

    @GetMapping("/employee/{employeeId}")
    @Operation(summary = "Поиск всех перингов по сотруднику")
    public List<PairingDto> findPairingByEmployee(@PathVariable Long employeeId) {
        var pairings = pairingDbService.findByEmployee(employeeDbService.getById(employeeId));
        return mapper.mapAll(pairings, PairingDto.class);
    }

}
