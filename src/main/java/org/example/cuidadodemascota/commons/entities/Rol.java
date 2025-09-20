package org.example.cuidadodemascota.commons.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Rol extends BaseEntity {

    @Column(name = "name", nullable = false, length = 20)
    private String name;
}

