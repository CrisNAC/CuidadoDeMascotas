package org.example.cuidadodemascota.commons.entities.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.reservation.Reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class Invoice extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_reservation", nullable = false)
    private Reservation reservation;

    @NotNull
    @Column(name = "issue_date", nullable = false)
    private LocalDateTime issueDate;

    @NotNull
    @Positive
    @Column(name = "total_amount", nullable = false, precision = 8, scale = 0)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    private Set<PaymentDetail> paymentDetails = new HashSet<>();
}
