package org.example.cuidadodemascota.commons.entities.credential;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
public class UserRole extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_role", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;
}
