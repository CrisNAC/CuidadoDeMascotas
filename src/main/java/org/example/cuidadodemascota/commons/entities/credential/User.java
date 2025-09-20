package org.example.cuidadodemascota.commons.entities.credential;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cuidadodemascota.commons.entities.service.Service;
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
    private Rol rol;

    @Column(name = "state", nullable = false)
    private Boolean state = true;

    @Column(name = "profile_photo", columnDefinition = "TEXT")
    private String profilePhoto;

    /*
    * Un User puede marcar como favoritos muchos Service.
    * Un Service puede ser favorito de muchos User.
    * */
    @ManyToMany
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> favoriteServices = new HashSet<>();
}
