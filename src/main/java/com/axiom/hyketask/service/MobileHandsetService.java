package com.axiom.hyketask.service;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;
import com.axiom.hyketask.service.filter.InMemoryMobileFilterBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MobileHandsetService {

    private final RestTemplate restTemplate;
    private final InMemoryMobileFilterBuilder inMemoryMobileFilterBuilder;

    @Value("${hyke.mobiledata-endpoint.url}")
    private String url;

    public List<MobileHandsetDTO> mobileHandsetList(MobileFilterParamsDTO filter) {
        var result = Optional.ofNullable(
                restTemplate.getForObject(url, MobileHandsetDTO[].class))
                .map(Arrays::asList)
                .orElse(List.of());
        var combinedFilters = inMemoryMobileFilterBuilder.buildFilters(filter);
        return result.stream()
                .filter(combinedFilters)
                .collect(Collectors.toList());
    }
}
