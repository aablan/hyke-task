package com.axiom.hyketask.repository.mongo;

import com.axiom.hyketask.dto.MobileHandsetDTO;
import com.axiom.hyketask.dto.ReleaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Release {
    private String announceDate;
    private Integer priceEur;

    public ReleaseDTO toDto() {
        return ReleaseDTO.builder()
                .announceDate(this.announceDate)
                .priceEur(this.priceEur)
                .build();
    }
}
