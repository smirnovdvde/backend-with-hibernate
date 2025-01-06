package ru.backendbyjava.domain.repository.nplusone;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.backendbyjava.domain.model.nplusone.LazyUser;

import java.util.UUID;

public interface LazyUserRepository extends JpaRepository<LazyUser, UUID> {
}
