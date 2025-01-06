package ru.backendbyjava.domain.repository.refintegity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.backendbyjava.domain.refintegrity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
