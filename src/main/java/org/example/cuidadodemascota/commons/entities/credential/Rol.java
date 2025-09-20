package org.example.cuidadodemascota.commons.entities.credential;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Rol extends BaseEntity {

    @Column(name = "name", nullable = false, length = 20)
    private String name;
}

