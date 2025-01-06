package ru.backendbyjava.domain.repository.refintegity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.backendbyjava.domain.refintegrity.Dog;

import java.util.UUID;

public interface DogRepository extends JpaRepository<Dog, UUID> {
}
