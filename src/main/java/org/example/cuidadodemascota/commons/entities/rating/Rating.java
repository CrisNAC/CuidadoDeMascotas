package org.example.cuidadodemascota.commons.entities.rating;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;
import org.example.cuidadodemascota.commons.entities.reservation.Reservation;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ratings")
public class Rating extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "fk_reservation", nullable = false, unique = true)
    private Reservation reservation;

    @Column(name = "score", nullable = false)
    private Short score;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;
}
