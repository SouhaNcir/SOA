package com.souha.voiture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoitureDto {
    private Long idVoiture;
    private String modele;
    private String voitserie;
    private String couleur;
    private String typeCarburant;
    private String boiteVitesse;
    private String codeMarque;
    private String nomMar;
    private String emailResponsable;
    private String mobileNumberResponsable;


}
