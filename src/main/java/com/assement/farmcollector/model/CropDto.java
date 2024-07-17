package com.assement.farmcollector.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CropDto {
    private String crop;
    private Integer expectedProductionInTon;
    private Integer actualHarvestedInTon;
}
