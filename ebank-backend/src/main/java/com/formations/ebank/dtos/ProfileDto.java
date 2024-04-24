package com.formations.ebank.dtos;

import com.formations.ebank.enums.EnumTypeProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {
    private Integer id;
    private EnumTypeProfile typeProfile;
    private List<UtilisateurProfileDto>UtilisateurProfileDto= Collections.emptyList();
}
