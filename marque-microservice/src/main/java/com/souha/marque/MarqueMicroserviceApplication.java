package com.souha.marque;

import com.souha.marque.entities.Marque;
import com.souha.marque.repos.MarqueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarqueMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarqueMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MarqueRepository marqueRepository) {
        return args -> {
            marqueRepository.save(Marque.builder()
                    .nomMar("Toyota").paysOrigine("Japon").codeMarque("M001").build());
            marqueRepository.save(Marque.builder()
                    .nomMar("BMW").paysOrigine("Allemagne").codeMarque("M002").build());
            marqueRepository.save(Marque.builder()
                    .nomMar("Peugeot").paysOrigine("France").codeMarque("M003").build());
        };
    }
}