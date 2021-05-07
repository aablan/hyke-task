package com.axiom.hyketask.service.filter;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;

import java.util.function.Predicate;

public interface InMemoryMobileFilter
        extends MobileFilter<Predicate<MobileHandsetDTO>, MobileFilterParamsDTO> {
}
