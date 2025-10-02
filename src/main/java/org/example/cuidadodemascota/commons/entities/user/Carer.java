package org.example.cuidadodemascota.commons.entities.user;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.credential.User;
import org.example.cuidadodemascota.commons.entities.enums.AvailabilityState;
import org.example.cuidadodemascota.commons.entities.reservation.Reservation;
import org.example.cuidadodemascota.commons.entities.service.Service;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "carers")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_carer")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Carer extends AbstractEntity {

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false, unique = true)
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "enum_availability_state", nullable = false, length = 20)
    private AvailabilityState state;

    @Positive
    @Column (nullable = false)
    private Short amount_pet;

    // 1-N -> services
    @OneToMany(mappedBy = "carer", fetch = FetchType.LAZY)
    private Set<Service> services = new HashSet<>();

    // 1-N -> reservations
    @OneToMany(mappedBy = "carer", fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<>();
}
