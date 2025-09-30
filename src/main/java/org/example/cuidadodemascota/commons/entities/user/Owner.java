package org.example.cuidadodemascota.commons.entities.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.credential.User;
import org.example.cuidadodemascota.commons.entities.pet.Pet;
import org.example.cuidadodemascota.commons.entities.reservation.Reservation;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "owners")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_owner")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Owner extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false, unique = true)
    private User user;

    // 1-N -> pets
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private Set<Pet> pets = new HashSet<>();

    // 1-N -> reservations
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<>();
}
