package com.axiom.hyketask.repository;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;

import java.util.List;

/**
 * This is general mobile data repository,
 * it can be extended by any type of database (SQl, NoSql)
 */
public interface MobileDataRepository {

    List<MobileHandsetDTO> mobileData(MobileFilterParamsDTO filter);
}
