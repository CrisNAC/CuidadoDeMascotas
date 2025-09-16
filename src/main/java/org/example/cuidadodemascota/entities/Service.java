package org.example.cuidadodemascota.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "services")
public class Service extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_service_type", nullable = false)
    private ServiceType serviceType;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "low_price", nullable = false, precision = 8, scale = 2)
    private BigDecimal lowPrice;

    @Column(name = "high_price", nullable = false, precision = 8, scale = 2)
    private BigDecimal highPrice;
}
