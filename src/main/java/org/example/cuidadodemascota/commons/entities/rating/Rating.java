package org.example.cuidadodemascota.commons.entities.rating;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.BaseEntity;
import org.example.cuidadodemascota.commons.entities.credential.User;
import org.example.cuidadodemascota.commons.entities.reservation.Reservation;

@Getter
@Setter
@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity {

    // Relacion rating - reservation
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_reservation", nullable = false, unique = true)
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_owner", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_carer", nullable = false)
    private User carer;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "comment", nullable = false, length = 255)
    private String comment;
}
