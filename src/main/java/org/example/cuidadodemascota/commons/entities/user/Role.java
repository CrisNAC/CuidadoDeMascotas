package org.example.cuidadodemascota.commons.entities.user;

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
    @Size(max = 10)
    @Column(name = "name", nullable = false, length = 10)
    private String name;

  /*  @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();*/

    //refleja el lado 1 de la relacion con UserRole
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

}
