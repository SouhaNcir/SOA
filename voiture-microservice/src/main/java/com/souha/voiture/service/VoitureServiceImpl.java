package com.souha.voiture.service;

import com.souha.voiture.dto.APIResponseDto;
import com.souha.voiture.dto.MarqueDto;
import com.souha.voiture.dto.VoitureDto;
import com.souha.voiture.entities.Voiture;
import com.souha.voiture.repos.VoitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class VoitureServiceImpl implements VoitureService {

    private VoitureRepository voitureRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getVoitureById(Long id) {
        Voiture voit = voitureRepository.findById(id).get();

        MarqueDto marqueDto = apiClient.getMarqueByCode(voit.getCodeMarque());

        VoitureDto voitureDto = new VoitureDto(
                voit.getIdVoiture(),
                voit.getModele(),
                voit.getVoitserie(),
                voit.getCouleur(),
                voit.getTypeCarburant(),
                voit.getBoiteVitesse(),
                voit.getCodeMarque(),
                marqueDto.getNomMar()
        );

        APIResponseDto response = new APIResponseDto();
        response.setVoitureDto(voitureDto);
        response.setMarqueDto(marqueDto);
        return response;
    }
}