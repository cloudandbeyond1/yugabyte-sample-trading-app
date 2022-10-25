package com.yugabyte.samples.tradex.api.web;

import com.yugabyte.samples.tradex.api.model.DBClusterInfo;
import com.yugabyte.samples.tradex.api.model.StockSymbol;
import com.yugabyte.samples.tradex.api.model.TrafficLocation;
import com.yugabyte.samples.tradex.api.service.ApplicationServiceException;
import com.yugabyte.samples.tradex.api.service.RefDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ReferenceDataController {

  @Autowired
  RefDataService refDataService;

  @GetMapping("/api/refdata/trafficLoc")
  public List<TrafficLocation> getTrafficLocations() throws ApplicationServiceException {
    return refDataService.getTrafficLocations();
  }

  @GetMapping("/api/refdata/dbcluster")
  public List<DBClusterInfo> getDBClusters() throws ApplicationServiceException {
    return refDataService.getDbClusters();
  }

  @GetMapping("/api/refdata/symbols")
  public List<StockSymbol> getStockSymbols() throws ApplicationServiceException {
    return refDataService.getStockSymbols();
  }


}
