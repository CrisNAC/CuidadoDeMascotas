package org.example.cuidadodemascota.commons.entities.service;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.reservation.ReservationService;
import org.example.cuidadodemascota.commons.entities.user.Carer;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "services")
public class Service extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "fk_carer", nullable = false)
    private Carer carer;

    @ManyToOne
    @JoinColumn(name = "fk_service_type", nullable = false)
    private ServiceType serviceType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    // 1-N con ReservationService
    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    private Set<ReservationService> reservationServices = new HashSet<>();
}
