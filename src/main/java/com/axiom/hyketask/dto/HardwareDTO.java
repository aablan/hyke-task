package com.axiom.hyketask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HardwareDTO {
    private String audioJack;
    private String gps;
    private String battery;
}
