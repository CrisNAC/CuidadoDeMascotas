package org.example.cuidadodemascota.commons.entities.service;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "service_types")
@AttributeOverride(name = "id", column = @Column(name = "id_service_type"))
public class ServiceType extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    // 1-N -> services
    @OneToMany(mappedBy = "serviceType", fetch = FetchType.LAZY)
    private Set<Service> services = new HashSet<>();
}
