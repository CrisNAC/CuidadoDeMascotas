package org.example.cuidadodemascota.commons.entities.credential;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "El nombre del rol es obligatorio")
    @Size(max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    // refleja el lado 1 de la relacion con UserRole
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();
}
