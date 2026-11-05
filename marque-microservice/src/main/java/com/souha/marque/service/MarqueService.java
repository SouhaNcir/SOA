package com.souha.marque.service;

import com.souha.marque.dto.MarqueDto;

public interface MarqueService {
    MarqueDto getMarqueByCode(String codeMarque);
}
