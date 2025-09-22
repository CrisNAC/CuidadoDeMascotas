package org.example.cuidadodemascota.commons.entities.pet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "type_pet")
public class TypePet extends BaseEntity {

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    // 1-N -> breeds
    @OneToMany(mappedBy = "typePet", fetch = FetchType.LAZY)
    private Set<Breed> breeds = new HashSet<>();
}
