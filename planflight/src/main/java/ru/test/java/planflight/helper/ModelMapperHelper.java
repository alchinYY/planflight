package ru.test.java.planflight.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.test.java.planflight.exception.InternalServerException;
import ru.test.java.planflight.model.Employee;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ModelMapperHelper implements MapperHelper {

    private final ModelMapper modelMapper;

    @Override
    public <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    @Override
    public <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    @Override
    public <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }

}
