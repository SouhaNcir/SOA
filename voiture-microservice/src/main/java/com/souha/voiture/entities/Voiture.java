package com.souha.voiture.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoiture;
    private String modele;
    private String voitserie;
    private String couleur;
    private String typeCarburant;
    private String boiteVitesse;
    private String codeMarque;
    private String nomMar;                 // seulement s'il existe déjà chez toi
    private String emailResponsable;
    private String mobileNumberResponsable;
    private boolean communicationDone;
}