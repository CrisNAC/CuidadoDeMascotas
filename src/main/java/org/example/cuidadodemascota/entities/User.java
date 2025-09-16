package org.example.cuidadodemascota.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "hash_password", nullable = false, length = 255)
    private String hashPassword;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_rol", nullable = false)
    private Rol rol;

    @Column(name = "state", nullable = false)
    private Boolean state = true;

    @Column(name = "profile_photo", columnDefinition = "TEXT")
    private String profilePhoto;
}
