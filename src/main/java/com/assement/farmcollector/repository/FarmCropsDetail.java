package com.assement.farmcollector.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(FarmCropsDetail.CompositeKey.class)
public class FarmCropsDetail implements Persistable<FarmCropsDetail.CompositeKey> {
    @Id
    private String farm;

    @Id
    private String season;

    @Id
    private String crop;

    private Double plantingAreaInAcres;

    private Integer expectedProductionInTon;

    private Integer actualHarvestedInTon;

    @Transient
    private boolean isNew;

    @Override
    public FarmCropsDetail.CompositeKey getId() {
        return CompositeKey.builder().farm(this.farm).season(this.season).crop(this.crop).build();
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompositeKey implements Serializable {
        private static final long serialVersionUID = 4209514347790055129L;
        private String farm;
        private String season;
        private String crop;
    }

}
