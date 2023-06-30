package ru.test.java.planflight.helper;

import java.io.File;
import java.util.Collection;
import java.util.List;

public interface MapperHelper {

    <D, T> D map(final T entity, Class<D> outClass);
    <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass);
    <S, D> D map(final S source, D destination);

}
