package com.souha.voiture.service;

import com.souha.voiture.dto.MarqueDto;
import com.souha.voiture.dto.VoitureDto;
import org.springframework.stereotype.Component;

@Component
public class marqFallback  implements APIClient {
    @Override
    public MarqueDto getMarqueByCode(String marqueCode) {
        return null;
    }

}
