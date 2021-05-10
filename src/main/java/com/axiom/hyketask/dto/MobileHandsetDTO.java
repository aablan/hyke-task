package com.axiom.hyketask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobileHandsetDTO {
    private long itemNum;
    private String brand;
    private String phone;
    private String picture;
    private ReleaseDTO release;
    private String sim;
    private String resolution;
    private HardwareDTO hardware;
}
