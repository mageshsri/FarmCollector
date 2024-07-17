# FarmCollector
This APP provides the below REST End points

1) POST /farms/{farm}/seasons/{season}/crops/{crop}/farmCrops
    - API for creating the Crop plantation detail for a farm
   
2) PUT /farms/{farm}/seasons/{season}/crops/{crop}/farmCrops
    - API for updating the Crop plantation detail for a farm
   
3) PATCH /farms/{farm}/seasons/{season}/crops/{crop}/farmCrops
    - API for updating the Crop harvest detail for a farm
   
4) GET /farmCrops?season={season}&farm={farm}
    - API for fetching the Farm crop details either by Season or by farm & Season
   
