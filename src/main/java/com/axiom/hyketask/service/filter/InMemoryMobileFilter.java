package com.axiom.hyketask.service.filter;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;

import java.util.function.Predicate;

/**
 * Definition of mobile data filter, it is in memory filter
 */
public interface InMemoryMobileFilter
        extends Filter<Predicate<MobileHandsetDTO>, MobileFilterParamsDTO> {
}
