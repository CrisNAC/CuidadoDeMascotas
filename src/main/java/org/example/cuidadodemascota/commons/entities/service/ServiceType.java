package org.example.cuidadodemascota.commons.entities.service;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "service_types")
public class ServiceType extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;
}
