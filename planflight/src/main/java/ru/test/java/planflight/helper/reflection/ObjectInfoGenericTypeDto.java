package ru.test.java.planflight.helper.reflection;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ObjectInfoGenericTypeDto {

    private final String className;
    private final String genericName;

}
