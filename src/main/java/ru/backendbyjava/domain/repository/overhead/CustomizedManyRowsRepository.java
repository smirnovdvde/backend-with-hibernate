package ru.backendbyjava.domain.repository.overhead;

import ru.backendbyjava.domain.model.overhead.ManyRowsEntity;

import java.util.List;

public interface CustomizedManyRowsRepository {
    List<ManyRowsEntity> findAllUsingStatelessSession();

    void findAllUsingStream();
}
