package com.formations.ebank.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private Date dateAnniversaire;
    @Column(nullable = false,unique = true)
    private String adresseMail;
    @Column(nullable = false)
    private String adressePostale;
    private String login;
    private String password;
    @Transient
    private String passwordValidation;
    private String numeroIdentite;
    @ToString.Exclude
    @OneToMany(targetEntity = UtilisateurProfile.class,
            mappedBy = "utilisateur",
            cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<UtilisateurProfile> listUtilisateurProfile=Collections.emptyList();
    @OneToMany(mappedBy = "utilisateur",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @ToString.Exclude
    List<Compte> listComptes = Collections.emptyList();
    @ToString.Exclude
    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Operation> listOperations = Collections.emptyList();

}
