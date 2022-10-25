package com.yugabyte.samples.tradex.api.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.yugabyte.samples.tradex.api.model.DBClusterInfo;
import com.yugabyte.samples.tradex.api.model.StockSymbol;
import com.yugabyte.samples.tradex.api.model.TrafficLocation;
import com.yugabyte.samples.tradex.model.Tables;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.JSON;
import org.jooq.Record1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class RefDataService {

  @Autowired
  DSLContext dbContext;

  ObjectMapper mapper = new ObjectMapper();

  public List<TrafficLocation> getTrafficLocations() throws ApplicationServiceException {
    return fetchRefDataAsList("trafficlocations", TrafficLocation.class);
  }

  public List<DBClusterInfo> getDbClusters() throws ApplicationServiceException {
    return fetchRefDataAsList("DBClustersTypes", DBClusterInfo.class);
  }

  public List<StockSymbol> getStockSymbols() throws ApplicationServiceException {
    return fetchRefDataAsList("STOCK_SYMBOLS", StockSymbol.class);
  }

  private List fetchRefDataAsList(String keyname, Class targetType) throws ApplicationServiceException {
    Record1<JSON> trafficLocations = dbContext.select(Tables.REF_DATA.KEY_VALUE).from(Tables.REF_DATA).where(Tables.REF_DATA.KEY_NAME.eq(keyname)).fetchOne();
    try {
      ObjectNode node = mapper.readValue(trafficLocations.get(0).toString(), ObjectNode.class);
      JsonNode locations = node.get(keyname);
      TypeFactory typeFactory = mapper.getTypeFactory();
      return mapper.treeToValue(locations, typeFactory.constructCollectionType(List.class, targetType));
    } catch (JsonProcessingException e) {
      log.error("Failed parsing refdata: {}", e.getMessage());
    }

    throw new ApplicationServiceException("Failed to fetch reference data: " + keyname);
  }

}
