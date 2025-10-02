package org.example.cuidadodemascota.commons.entities.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
public class PaymentMethod extends BaseEntity {

    @NotBlank
    @Size(max = 60)
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY)
    private Set<PaymentDetail> paymentDetails = new HashSet<>();
}
