package ru.backendbyjava.domain.repository.nplusone;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.backendbyjava.domain.model.nplusone.EntityGraphUser;

import java.util.List;
import java.util.UUID;

public interface EntityGraphUserRepository extends JpaRepository<EntityGraphUser, UUID> {
    @EntityGraph(attributePaths = {"posts"})
    List<EntityGraphUser> findAll();
}
