package com.axiom.hyketask.repository.mongo;

import com.axiom.hyketask.dto.MobileHandsetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = MobileHandsetEntity.COLLECTION)
public class MobileHandsetEntity {
    public static final String COLLECTION = "mobile_data";

    private ObjectId id;
    private long itemNum;
    private String brand;
    private String phone;
    private String picture;
    private Release release;
    private String sim;
    private String resolution;
    private Hardware hardware;

    public MobileHandsetDTO toDto() {
        return MobileHandsetDTO.builder()
                .itemNum(this.itemNum)
                .brand(this.brand)
                .phone(this.phone)
                .picture(this.picture)
                .release(this.release.toDto())
                .sim(this.sim)
                .resolution(this.resolution)
                .hardware(this.hardware.toDto())
                .build();
    }
}
