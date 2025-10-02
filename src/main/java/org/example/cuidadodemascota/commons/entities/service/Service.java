package org.example.cuidadodemascota.commons.entities.service;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.reservation.ReservationService;
import org.example.cuidadodemascota.commons.entities.user.Carer;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "services")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_service")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Service extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_carer", nullable = false)
    private Carer carer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_service_type", nullable = false)
    private ServiceType serviceType;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Positive
    @Column(name = "price", nullable = false, precision = 8, scale = 0)
    private BigDecimal price;

    // 1-N con ReservationService
    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    private Set<ReservationService> reservationServices = new HashSet<>();
}
