package org.example.cuidadodemascota.commons.entities.credential;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.user.Owner;
import org.example.cuidadodemascota.commons.entities.user.Carer;
import org.example.cuidadodemascota.commons.entities.base.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "hash_password", nullable = false, columnDefinition = "TEXT")
    private String hashPassword;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_rol", nullable = false)
    private Role rol;

    @Column(name = "state", nullable = false)
    private Boolean state = true;

    @Column(name = "profile_photo", columnDefinition = "TEXT")
    private String profilePhoto;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Owner owner;

    @OneToOne(mappedBy = "user")
    private Carer carer;
}
