package ru.backendbyjava.domain.refintegrity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "posts")
@Entity
@Setter
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Post {
    @Id
    private UUID id;
    private String title;
    private String body;
    private String status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
