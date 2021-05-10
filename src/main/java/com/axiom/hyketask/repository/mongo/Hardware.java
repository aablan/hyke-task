package com.axiom.hyketask.repository.mongo;

import com.axiom.hyketask.dto.HardwareDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {

    private String audioJack;
    private String gps;
    private String battery;

    public HardwareDTO toDto() {
        return HardwareDTO.builder()
                .audioJack(this.audioJack)
                .gps(this.gps)
                .battery(this.battery)
                .build();
    }
}
