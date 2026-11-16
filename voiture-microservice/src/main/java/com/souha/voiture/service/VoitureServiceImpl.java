package com.souha.voiture.service;

import com.souha.voiture.dto.APIResponseDto;
import com.souha.voiture.dto.MarqueDto;
import com.souha.voiture.dto.VoitureDto;
import com.souha.voiture.dto.VoitureMessageDto;
import com.souha.voiture.entities.Voiture;
import com.souha.voiture.exceptions.ResourceNotFoundException;
import com.souha.voiture.repos.VoitureRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VoitureServiceImpl implements VoitureService {

    private static final Logger log = LoggerFactory.getLogger(VoitureServiceImpl.class);

    private VoitureRepository voitureRepository;
    private APIClient apiClient;
    private StreamBridge streamBridge;

    @Override
    public APIResponseDto getVoitureById(Long id) {
        Voiture voit = voitureRepository.findById(id).get();

        MarqueDto marqueDto = apiClient.getMarqueByCode(voit.getCodeMarque());
        String dname = (marqueDto == null) ? "nondefined" : marqueDto.getNomMar();

        VoitureDto voitureDto = new VoitureDto(
                voit.getIdVoiture(),
                voit.getModele(),
                voit.getVoitserie(),
                voit.getCouleur(),
                voit.getTypeCarburant(),
                voit.getBoiteVitesse(),
                voit.getCodeMarque(),
                dname,
                voit.getEmailResponsable(),
                voit.getMobileNumberResponsable()
        );

        APIResponseDto response = new APIResponseDto();
        response.setVoitureDto(voitureDto);
        response.setMarqueDto(marqueDto);
        return response;
    }

    @Override
    public void createVoiture(VoitureDto voitureDto) {
        Voiture savedVoiture = voitureRepository.save(Voiture.builder()
                .modele(voitureDto.getModele())
                .voitserie(voitureDto.getVoitserie())
                .couleur(voitureDto.getCouleur())
                .typeCarburant(voitureDto.getTypeCarburant())
                .boiteVitesse(voitureDto.getBoiteVitesse())
                .codeMarque(voitureDto.getCodeMarque())
                .emailResponsable(voitureDto.getEmailResponsable())
                .mobileNumberResponsable(voitureDto.getMobileNumberResponsable())
                .build());
        sendCommunication(savedVoiture);
    }

    @Override
    public boolean updateCommunicationStatus(Long voitureId) {
        boolean isUpdated = false;
        if(voitureId !=null ){
            Voiture voiture = voitureRepository.findById(voitureId).orElseThrow(
                    () -> new ResourceNotFoundException("Voiture", "VoitureId", voitureId.toString())
            );
            voiture.setCommunicationDone(true);
            voitureRepository.save(voiture);
            isUpdated = true;
        }
        return isUpdated;
    }

    private void sendCommunication(Voiture voiture) {
        var msg = new VoitureMessageDto(
                voiture.getIdVoiture(),
                voiture.getEmailResponsable(),
                voiture.getMobileNumberResponsable()
        );
        log.info("Sending Communication request for the details: {}", msg);
        var result = streamBridge.send("sendCommunication-out-0", msg);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }
}