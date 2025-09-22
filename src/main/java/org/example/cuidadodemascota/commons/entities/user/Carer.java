package org.example.cuidadodemascota.commons.entities.user;

import jakarta.persistence.*;
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
public class Carer extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false, unique = true)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "enum_availability_state", nullable = false, length = 20)
    private AvailabilityState state;

    @Column (nullable = false)
    private Short amount_pet;

    // 1-N -> services
    @OneToMany(mappedBy = "carer", fetch = FetchType.LAZY)
    private Set<Service> services = new HashSet<>();

    // 1-N -> reservations
    @OneToMany(mappedBy = "carer", fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<>();
}
