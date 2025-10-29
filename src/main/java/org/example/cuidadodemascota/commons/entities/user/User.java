package org.example.cuidadodemascota.commons.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.enums.AvailabilityStateEnum;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_user")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class User extends AbstractEntity {

    @NotBlank
    @Size(max = 60)
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @NotBlank
    @Size(max = 60)
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @NotBlank
    @Email
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    // 0985 123456 o +595 985 123456
    @NotBlank
    @Pattern(regexp = "\\d{10,13}", message = "Debe tener entre 10 y 13 digitos")
    @Column(name = "phone_number", nullable = false, length = 13)
    private String phoneNumber;

    @Column(name = "profile_photo", columnDefinition = "TEXT")
    private String profilePhoto;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "enum_availability_state", nullable = false, length = 20)
    private AvailabilityStateEnum state;

    // relfeja la relacion con UserRole
    // N:M entre users y roles
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();
}
