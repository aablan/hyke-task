package com.axiom.hyketask.service.filter;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Component
public class InMemoryMobileFilterBuilder{

    private final List<InMemoryMobileFilter> filters;

    public Predicate<MobileHandsetDTO> buildFilters(MobileFilterParamsDTO filter){
        return filters.stream()
                .filter(item -> item.shouldCompute(filter))
                .map(item -> item.filter(filter))
                .reduce(Predicate::and)
                .orElse(item -> true);
    }
}
