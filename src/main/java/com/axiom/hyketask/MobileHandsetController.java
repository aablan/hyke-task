package com.axiom.hyketask;

import com.axiom.hyketask.api.MobileHandsetApi;
import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;
import com.axiom.hyketask.service.MobileHandsetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RequestMapping({"", "/v1"})
@RestController
public class MobileHandsetController implements MobileHandsetApi {

    private final MobileHandsetService mobileHandsetService;

    @Override
    public List<MobileHandsetDTO> mobileHandsets(MobileFilterParamsDTO params) {
        return mobileHandsetService.mobileHandsetList(params);
    }
}
