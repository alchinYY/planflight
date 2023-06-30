package ru.test.java.planflight.helper;

import lombok.experimental.UtilityClass;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.util.ReflectionUtils;
import ru.test.java.planflight.exception.NotFoundException;
import ru.test.java.planflight.helper.reflection.ObjectInfoDto;
import ru.test.java.planflight.web.dto.PlanFlightDto;
import ru.test.java.planflight.helper.reflection.ObjectInfoGenericTypeDto;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static ru.test.java.planflight.config.MessageConstants.MESSAGE_CLASS_WITH_NAME_NOT_FOUND;

@UtilityClass
public class ReflectionHelper {

    public static Class<?> getClassByName(String packageName, String name) {
        try {
            return Class.forName(packageName + "." + name);
        } catch (ClassNotFoundException ex) {
            throw new NotFoundException(MESSAGE_CLASS_WITH_NAME_NOT_FOUND, name);
        }
    }

    public static ObjectInfoDto readFullInfoAboutObject(String packageName, String name){
        var objectInfoDto = new ObjectInfoDto(name);
        ReflectionUtils.doWithFields(
                ReflectionHelper.getClassByName(packageName, name), field -> readInfoAboutClassFields(objectInfoDto, field)
        );
        return objectInfoDto;
    }

    public static List<String> getClassesFromPackage(String packageName) {
        var reflections = new Reflections(packageName, new SubTypesScanner(false));
        return reflections.getSubTypesOf(PlanFlightDto.class)
                .stream()
                .map(Class::getSimpleName)
                .collect(Collectors.toList());
    }

    private void readInfoAboutClassFields(ObjectInfoDto objectInfoDto, Field field) {
        if (Collection.class.isAssignableFrom(field.getType())) {
            var stringListType = (ParameterizedType) field.getGenericType();
            objectInfoDto.putFields(field.getName(), createListGenericTypeInfo(field, stringListType));
        } else {
            objectInfoDto.putFields(field.getName(), field.getType().getSimpleName());
        }
    }

    private ObjectInfoGenericTypeDto createListGenericTypeInfo(Field field, ParameterizedType stringListType) {
        return new ObjectInfoGenericTypeDto(field.getType().getSimpleName(),
                stringListType.getActualTypeArguments()[0].getTypeName()
        );
    }
}
