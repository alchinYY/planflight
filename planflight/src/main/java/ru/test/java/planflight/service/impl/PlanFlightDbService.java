package ru.test.java.planflight.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.java.planflight.exception.NotFoundException;
import ru.test.java.planflight.model.PlanFlightEntity;
import ru.test.java.planflight.service.PlanFlightService;

import java.util.List;

import static ru.test.java.planflight.config.MessageConstants.MESSAGE_ENTITY_WITH_ID_NOT_FOUND;

@RequiredArgsConstructor
public class PlanFlightDbService<T  extends PlanFlightEntity, ID extends Number>
        implements PlanFlightService<T, ID >  {

    private final Class<T> entityClass;
    private final JpaRepository<T, ID> repository;

    @Override
    public T getById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(MESSAGE_ENTITY_WITH_ID_NOT_FOUND, entityClass.getSimpleName(), id));
    }

    @Override
    public List<T> upload(List<T> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public T upload(T entity) {
        return repository.save(entity);
    }
}
