package com.axiom.hyketask.api;

import com.axiom.hyketask.dto.MobileHandsetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("mobile")
public interface MobileHandsetApi {

    @GetMapping(
            value = "/mobile/search",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<MobileHandsetDTO> mobileHandsets();
}
