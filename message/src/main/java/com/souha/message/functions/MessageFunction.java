package com.souha.message.functions;

import com.souha.message.dto.VoitureMessageDto;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@Configuration
public class MessageFunction {
    private static final Logger log =
            LoggerFactory.getLogger(MessageFunction.class);
    @Bean
    public Function<VoitureMessageDto, VoitureMessageDto> email() {
        return dto -> {
            log.info("Sending email to {} with the details : {}", dto.emailResponsable(), dto);
            return dto;
        };
    }

    @Bean
    public Function<VoitureMessageDto, Long> sms() {
        return dto -> {
            log.info("Sending sms to {} with the details : {}", dto.mobileNumberResponsable(), dto);
            return dto.idVoiture();
        };
    }

}
