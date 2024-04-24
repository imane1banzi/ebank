package com.formations.ebank.entities;

import com.formations.ebank.enums.EnumStatusCompte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Compte  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.ORDINAL)
    @JdbcTypeCode(SqlTypes.ENUM)
    private EnumStatusCompte statusCompte;
    private  Double solde;
    @Column(length = 27,unique = true,nullable = false)
    private String rib;
    @ManyToOne(targetEntity = Utilisateur.class)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

}
