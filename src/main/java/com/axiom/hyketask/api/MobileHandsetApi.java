package com.axiom.hyketask.api;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * This Api client provides definitions of operations on MobileHandset resource
 *
 */
@FeignClient("mobile")
public interface MobileHandsetApi {

    @GetMapping(
            value = "/mobile/search",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<MobileHandsetDTO> mobileHandsets(@QueryMap MobileFilterParamsDTO params);
}
