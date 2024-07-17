package com.assement.farmcollector.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CropHarvestedDetailDto {
    private Integer actualHarvestedInTon;
}
