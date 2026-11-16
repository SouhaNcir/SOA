package com.souha.voiture.service;

import com.souha.voiture.dto.APIResponseDto;
import com.souha.voiture.dto.VoitureDto;

public interface VoitureService {
    APIResponseDto getVoitureById(Long id);
    void createVoiture(VoitureDto voitureDto);
    boolean updateCommunicationStatus(Long voitureId);
}