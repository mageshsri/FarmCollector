package com.assement.farmcollector.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CropPlantationDetailDto {
    private Double plantingAreaInAcres;
    private Integer expectedProductionInTon;
}
