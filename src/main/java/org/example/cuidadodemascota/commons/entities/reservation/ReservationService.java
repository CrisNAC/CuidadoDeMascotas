package org.example.cuidadodemascota.commons.entities.reservation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.pet.Pet;
import org.example.cuidadodemascota.commons.entities.service.Service;

@Getter
@Setter
@Entity
@Table(name = "reservation_services")
public class ReservationService extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "fk_reservation", nullable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "fk_service", nullable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "fk_pet", nullable = false)
    private Pet pet;
}
