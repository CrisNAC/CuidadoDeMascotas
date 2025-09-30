package org.example.cuidadodemascota.commons.entities.pet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.enums.PetSize;
import org.example.cuidadodemascota.commons.entities.user.Owner;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pets")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_pet")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at")),
})
public class Pet extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "id_owner", nullable = false)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "fk_breed", nullable = false)
    private Breed breed;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "enum_pet_sizes", nullable = false, length = 10)
    private PetSize size;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "profile_photo", columnDefinition = "TEXT")
    private String profilePhoto;
}
