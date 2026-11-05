package com.souha.voiture;

import com.souha.voiture.entities.Voiture;
import com.souha.voiture.repos.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class VoitureMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(VoitureRepository voitureRepository) {
        return args -> {
            voitureRepository.save(Voiture.builder().modele("Corolla").voitserie("V001")
                    .couleur("Rouge").typeCarburant("Essence").boiteVitesse("Manuelle")
                    .codeMarque("M001").build());
            voitureRepository.save(Voiture.builder().modele("Serie 3").voitserie("V002")
                    .couleur("Noire").typeCarburant("Diesel").boiteVitesse("Automatique")
                    .codeMarque("M002").build());
            voitureRepository.save(Voiture.builder().modele("208").voitserie("V003")
                    .couleur("Blanche").typeCarburant("Essence").boiteVitesse("Manuelle")
                    .codeMarque("M003").build());
        };
    }
}