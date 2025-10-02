package org.example.cuidadodemascota.commons.entities.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "payment_details")
@Getter
@Setter
public class PaymentDetail extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_invoice", nullable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @NotNull
    @Positive
    @Column(name = "applied_amount", nullable = false, precision = 8, scale = 0)
    private BigDecimal appliedAmount;
}
