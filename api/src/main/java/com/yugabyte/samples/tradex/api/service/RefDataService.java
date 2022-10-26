package com.yugabyte.samples.tradex.api.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.yugabyte.samples.tradex.api.model.DBClusterInfo;
import com.yugabyte.samples.tradex.api.model.RefDatum;
import com.yugabyte.samples.tradex.api.model.StockSymbol;
import com.yugabyte.samples.tradex.api.model.TrafficLocation;
import com.yugabyte.samples.tradex.api.repo.RefDatumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class RefDataService {

  ObjectMapper mapper = new ObjectMapper();

  RefDatumRepository refDatumRepository;

  @Autowired
  public RefDataService(RefDatumRepository refDatumRepository) {
    this.refDatumRepository = refDatumRepository;
  }

  public List<TrafficLocation> getTrafficLocations() throws ApplicationServiceException {
    return fetchRefDataAsList("trafficlocations", TrafficLocation.class);
  }

  public List<DBClusterInfo> getDbClusterTypes() throws ApplicationServiceException {
    return fetchRefDataAsList("DBClustersTypes", DBClusterInfo.class);
  }

  public List<StockSymbol> getStockSymbols() throws ApplicationServiceException {
    return fetchRefDataAsList("STOCK_SYMBOLS", StockSymbol.class);
  }

  private List fetchRefDataAsList(String keyname, Class targetType) throws ApplicationServiceException {
    try {
      RefDatum refData = refDatumRepository.findByKeyName(keyname);
      ObjectNode node = mapper.readValue(refData.getKeyValue().toString(), ObjectNode.class);
      JsonNode locations = node.get(keyname);
      TypeFactory typeFactory = mapper.getTypeFactory();
      return mapper.treeToValue(locations, typeFactory.constructCollectionType(List.class, targetType));
    } catch (JsonProcessingException e) {
      log.error("Failed parsing refdata: {}", e.getMessage());
      throw new ApplicationServiceException("Failed to fetch reference data: " + keyname);
    }

  }
}
