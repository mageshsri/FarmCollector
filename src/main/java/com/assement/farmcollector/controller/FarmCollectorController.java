package com.assement.farmcollector.controller;

import com.assement.farmcollector.model.*;
import com.assement.farmcollector.service.FarmCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmCollectorController {

    @Autowired
    FarmCollectorService farmCollectorService;

    /**
     * POST API for creating the Crop plantation detail for a farm
     * @Param farm name of the farm for which the plantation details to be inserted
     * @Param season name of the season
     * @Param crop name of the crop
     * @Param cropPlantationDetailDto request payload
     * @return message containing the result of insert operation
     */
    @PostMapping(path = "/farms/{farm}/seasons/{season}/crops/{crop}/farmCrops",
            consumes = "application/json", produces = "application/json")
    public FarmCropsResponse insertCropPlantation(@PathVariable("farm") String farm, @PathVariable("season") String season,
                                                  @PathVariable("crop") String crop, @RequestBody CropPlantationDetailDto cropPlantationDetailDto) {
        farmCollectorService.addPlantationDetail(farm, season, crop, cropPlantationDetailDto);
        return FarmCropsResponse.builder().message("Crop Plantation details inserted successfully").build();
    }

    /**
     * PUT API for updating the Crop plantation detail for a farm
     * @Param farm name of the form for which the plantation details to be updated
     * @Param season name of the season
     * @Param crop name of the crop
     * @Param cropPlantationDetailDto request payload
     * @return message containing the result of update operation
     */
    @PutMapping(path = "/farms/{farm}/seasons/{season}/crops/{crop}/farmCrops",
            consumes = "application/json", produces = "application/json")
    public FarmCropsResponse updateCropPlantation(@PathVariable("farm") String farm, @PathVariable("season") String season,
                                                  @PathVariable("crop") String crop, @RequestBody CropPlantationDetailDto cropPlantationDetailDto) {
        farmCollectorService.updatePlantationDetail(farm, season, crop, cropPlantationDetailDto);
        return FarmCropsResponse.builder().message("Crop Plantation details updated successfully").build();
    }

    /**
     * PATCH API for updating the Crop harvest detail for a farm
     * @Param farm name of the form for which the harvest details to be updated
     * @Param season name of the season
     * @Param crop name of the crop
     * @Param cropHarvestedDetailDto request payload
     * @return message containing the result of update operation
     */
    @PatchMapping(path = "/farms/{farm}/seasons/{season}/crops/{crop}/farmCrops",
            consumes = "application/json", produces = "application/json")
    public FarmCropsResponse updateCropHarvest(@PathVariable("farm") String farm, @PathVariable("season") String season,
                                               @PathVariable("crop") String crop, @RequestBody CropHarvestedDetailDto cropHarvestedDetailDto) {
        farmCollectorService.updateHarvestationDetail(farm, season, crop, cropHarvestedDetailDto);
        return FarmCropsResponse.builder().message("Crop Harvest details updated successfully").build();
    }

    /**
     * GET API for fetching the Farm crop details either by Season or by farm & Season
     * @Param farm name of the form for which the harvest details to be updated
     * @Param season name of the season
     * @Param crop name of the crop
     * @return farmCropsDtos search result containing the form crop details
     */
    @GetMapping(path = "/farmCrops", produces = "application/json")
    public FarmCropsReportDto searchFarmCropDetails(@RequestParam(name = "season", required = true) String season,
                                                    @RequestParam(name = "farm", required = false) String farm) {
        List<FarmCropsDto> farmCropsDtos = farmCollectorService.searchFarmCropDetails(season, farm);
        return FarmCropsReportDto.builder().farmCrops(farmCropsDtos).build();
    }
}
