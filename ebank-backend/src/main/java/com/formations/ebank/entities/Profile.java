package com.formations.ebank.entities;

import com.formations.ebank.enums.EnumTypeProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.ORDINAL)
    @JdbcTypeCode(SqlTypes.ENUM)
    @Column(nullable = false,unique = true)
    private EnumTypeProfile typeProfile;
    @OneToMany(targetEntity = UtilisateurProfile.class,
            mappedBy = "profile",fetch = FetchType.EAGER,cascade =CascadeType.ALL)
    private List<UtilisateurProfile>listUtilisateurProfile= Collections.emptyList();
}
