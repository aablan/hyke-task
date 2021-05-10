package com.axiom.hyketask.repository.mongo;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.repository.Filter;
import org.springframework.data.mongodb.core.query.Criteria;

public interface MongoMobileHandsetFilter
        extends Filter<Criteria, MobileFilterParamsDTO> {
}
