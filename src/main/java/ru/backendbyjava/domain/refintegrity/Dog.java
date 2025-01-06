package ru.backendbyjava.domain.refintegrity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name = "dogs")
@Entity
@Setter
@Getter
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Dog extends Pet {
    private String breed;
}
