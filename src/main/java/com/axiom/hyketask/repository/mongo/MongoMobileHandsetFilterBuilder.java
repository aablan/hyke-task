package com.axiom.hyketask.repository.mongo;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MongoMobileHandsetFilterBuilder {

    private final List<MongoMobileHandsetFilter> filters;

    public Criteria buildFilters(MobileFilterParamsDTO filter){
        return filters.stream()
                .filter(item -> item.shouldCompute(filter))
                .map(item -> item.filter(filter))
                .reduce(Criteria::andOperator)
                .orElse(new Criteria());
    }
}
