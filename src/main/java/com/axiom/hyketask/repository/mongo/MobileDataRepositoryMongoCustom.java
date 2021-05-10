package com.axiom.hyketask.repository.mongo;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;
import com.axiom.hyketask.repository.MobileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Repository
public class MobileDataRepositoryMongoCustom implements MobileDataRepository {


    private final MongoMobileHandsetFilterBuilder mobileDataFilterBuilder;
    private final MongoTemplate mongoTemplate;

    @Override
    public List<MobileHandsetDTO> mobileData(MobileFilterParamsDTO filter) {
        var criteria = mobileDataFilterBuilder.buildFilters(filter);
        var query = new Query(criteria);
        return mongoTemplate.find(query, MobileHandsetEntity.class)
                .stream()
                .map(MobileHandsetEntity::toDto)
                .collect(toList());
    }
}
