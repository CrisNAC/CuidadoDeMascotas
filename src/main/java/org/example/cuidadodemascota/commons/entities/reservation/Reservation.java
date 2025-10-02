package org.example.cuidadodemascota.commons.entities.reservation;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.enums.ReservationState;
import org.example.cuidadodemascota.commons.entities.invoice.Invoice;
import org.example.cuidadodemascota.commons.entities.user.Owner;
import org.example.cuidadodemascota.commons.entities.user.Carer;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "reservations")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_reservation")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Reservation extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_owner", nullable = false)
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_carer", nullable = false)
    private Carer carer;

    @NotNull
    @Column(name = "service_date", nullable = false)
    private LocalDateTime serviceDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "enum_reservation_state", nullable = false, length = 20)
    private ReservationState state;

    // 1-N -> reservation_services
    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
    private Set<ReservationService> reservationServices = new HashSet<>();

    @OneToOne(mappedBy = "reservation")
    private Invoice invoice;
}
