package ru.backendbyjava.domain.model.overhead;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "many_rows")
@Entity
@Setter
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class ManyRowsEntity {
    @Id
    private UUID id;
    private String name;
}
