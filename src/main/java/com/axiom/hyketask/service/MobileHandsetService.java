package com.axiom.hyketask.service;

import com.axiom.hyketask.dto.MobileFilterParamsDTO;
import com.axiom.hyketask.dto.MobileHandsetDTO;
import com.axiom.hyketask.repository.MobileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MobileHandsetService {

    private final MobileDataRepository mobileDataRepository;

    public List<MobileHandsetDTO> mobileHandsetList(MobileFilterParamsDTO filter) {
        return mobileDataRepository.mobileData(filter);
    }
}
