package ru.backendbyjava.domain.repository.refintegity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.backendbyjava.domain.refintegrity.Post;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
