package com.axiom.hyketask.service.filter;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Predicate;

@Component
public class AnnounceDateFilter implements InMemoryMobileFilter {

    @Override
    public Predicate<MobileHandsetDTO> filter(MobileFilterParamsDTO filter) {
        return item -> Objects.nonNull(item.getRelease().getAnnounceDate()) &&
                item.getRelease().getAnnounceDate().contains(filter.getAnnounceDate());
    }

    @Override
    public boolean shouldCompute(MobileFilterParamsDTO filter) {
        return Objects.nonNull(filter.getAnnounceDate());
    }
}
