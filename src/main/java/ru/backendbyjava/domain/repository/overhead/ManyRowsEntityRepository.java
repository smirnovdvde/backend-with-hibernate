package ru.backendbyjava.domain.repository.overhead;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.backendbyjava.domain.model.overhead.ManyRowsEntity;
import ru.backendbyjava.domain.model.overhead.ManyRowsNameProjection;

import java.util.List;
import java.util.UUID;

public interface ManyRowsEntityRepository extends JpaRepository<ManyRowsEntity, UUID>, CustomizedManyRowsRepository {
    List<ManyRowsNameProjection> findAllByNameLike(String namePattern);
};
