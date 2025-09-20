package org.example.cuidadodemascota.commons.entities.base;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass // <- esta anotacion indica que no se mapea directamente a tabla
public abstract class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // unico para todas las entidades

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // clave primaria generica
}
