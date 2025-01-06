package ru.backendbyjava.domain.repository.nplusone;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.backendbyjava.domain.model.nplusone.BatchUser;

import java.util.UUID;

public interface BatchUserRepository extends JpaRepository<BatchUser, UUID> {
}
