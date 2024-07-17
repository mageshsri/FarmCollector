package com.assement.farmcollector.repository;

import com.assement.farmcollector.repository.FarmCropsDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public interface FarmCropsDetailRepository  extends CrudRepository<FarmCropsDetail, FarmCropsDetail.CompositeKey> {

    public List<FarmCropsDetail> findBySeason(String Season);
    public List<FarmCropsDetail> findByFarmAndSeason(String farm, String Season);
}
