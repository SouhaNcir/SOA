package com.souha.marque.service;

import com.souha.marque.entities.Marque;
import com.souha.marque.dto.MarqueDto;
import com.souha.marque.repos.MarqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class MarqueServiceImpl implements MarqueService {
    @Autowired
    MarqueRepository marqueRepository;

    @Override
    public MarqueDto getMarqueByCode(String codeMarque) {
        Marque m = marqueRepository.findByCodeMarque(codeMarque);
        return new MarqueDto(m.getId(), m.getNomMar(), m.getPaysOrigine(), m.getCodeMarque());
    }
}