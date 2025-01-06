package ru.backendbyjava.domain.refintegrity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import static jakarta.persistence.InheritanceType.JOINED;

@Table(name = "pets")
@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Inheritance(strategy = JOINED)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nickname;
}
