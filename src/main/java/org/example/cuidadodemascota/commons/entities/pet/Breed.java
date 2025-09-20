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
@Table(name = "breed")
public class Breed extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "fk_type_of_pet", nullable = false)
    private TypePet typePet;

    @Column(nullable = false, length = 60)
    private String name;

    // 1-N -> pets
    @OneToMany(mappedBy = "breed", fetch = FetchType.LAZY)
    private Set<Pet> pets = new HashSet<>();
}
