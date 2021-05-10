package com.axiom.hyketask.repository.mongo;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AnnounceDateFilterMongo implements MongoMobileHandsetFilter {
    @Override
    public Criteria filter(MobileFilterParamsDTO filter) {
        return Criteria.where("release.announceDate").regex(filter.getAnnounceDate(), "i");
    }

    @Override
    public boolean shouldCompute(MobileFilterParamsDTO filter) {
        return Objects.nonNull(filter.getAnnounceDate());
    }
}
