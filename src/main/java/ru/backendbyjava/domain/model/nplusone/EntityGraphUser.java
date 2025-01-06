package ru.backendbyjava.domain.model.nplusone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "users")
@Entity
@Setter
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class EntityGraphUser {
    @Id
    private UUID id;
    @Column(name = "user_name")
    private String userName;
    private String role;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<EntityGraphPost> posts;
}
