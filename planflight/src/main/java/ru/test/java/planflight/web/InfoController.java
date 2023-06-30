package ru.test.java.planflight.web;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.java.planflight.helper.ReflectionHelper;
import ru.test.java.planflight.helper.reflection.ObjectInfoDto;

import java.util.List;

@RestController
@RequestMapping("info")
public class InfoController {

    @Value("ru.test.java.planflight.web.dto.simple")
    private String pathToPackageWithDto;

    @GetMapping("/dtos")
    @Operation(summary = "Получить список dto для api")
    public List<String> getAvailableObjects() {
        return ReflectionHelper.getClassesFromPackage(pathToPackageWithDto);
    }

    @GetMapping("{object}")
    @Operation(summary = "Получить схему объекта")
    public ObjectInfoDto readSchema(@PathVariable String object) {
        return ReflectionHelper.readFullInfoAboutObject(pathToPackageWithDto, object);
    }






}
