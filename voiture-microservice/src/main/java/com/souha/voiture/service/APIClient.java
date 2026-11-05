package com.souha.voiture.service;

import com.souha.voiture.dto.MarqueDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MARQUE")
public interface APIClient {
    @GetMapping("/api/marques/{code}")
    MarqueDto getMarqueByCode(@PathVariable("code") String code);
}
