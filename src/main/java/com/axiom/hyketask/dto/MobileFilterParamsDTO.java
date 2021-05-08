package com.axiom.hyketask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobileFilterParamsDTO {
    private Integer price;
    private String brand;
    private String phone;
    private String sim;
    private String announceDate;
    private String audioJack;
    private String gps;
}
