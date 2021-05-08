package com.axiom.hyketask.service.filter;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Predicate;

@Component
public class BrandFilter implements InMemoryMobileFilter {

    @Override
    public Predicate<MobileHandsetDTO> filter(MobileFilterParamsDTO filter) {
        return item -> filter.getBrand().equalsIgnoreCase(item.getBrand());
    }

    @Override
    public boolean shouldCompute(MobileFilterParamsDTO filter) {
        return Objects.nonNull(filter.getBrand());
    }
}
