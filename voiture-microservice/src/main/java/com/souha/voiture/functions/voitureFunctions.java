package com.souha.voiture.functions;
import com.souha.voiture.service.VoitureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import java.util.function.Consumer;

@Configuration
public class voitureFunctions {
    private static final Logger log = LoggerFactory.getLogger(voitureFunctions.class);
    @Bean
    public Consumer<Long> updateCommunication(VoitureService voitureServiceService) {
        return teacherId -> {
            log.info("Updating Communication status for the teacher Id : " + teacherId.toString());
            voitureServiceService.updateCommunicationStatus(teacherId);

        };
    }

}
