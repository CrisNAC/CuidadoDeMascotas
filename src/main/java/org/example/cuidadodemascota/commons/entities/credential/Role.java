package org.example.cuidadodemascota.commons.entities.credential;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
@AttributeOverride(name = "id", column = @Column(name = "id_role"))
public class Role extends BaseEntity {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    // N-M con Users a través de UserRole
    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();
}
