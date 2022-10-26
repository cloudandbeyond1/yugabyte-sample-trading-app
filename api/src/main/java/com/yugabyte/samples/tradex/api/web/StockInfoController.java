package com.yugabyte.samples.tradex.api.web;

import com.yugabyte.samples.tradex.api.service.StockInfoService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;
import yahoofinance.histquotes.Interval;

@RestController
public class StockInfoController {

  @Autowired
  StockInfoService stockInfoService;

  @GetMapping("/api/stocks/{symbol}")
  @Operation(summary = "Fetch Stock Info from yahoo")
  public Stock fetchSingleStock(@PathVariable("symbol") String symbol,
                                @RequestParam(name = "hist", required = false, defaultValue = "N") boolean includeHist,
                                @RequestParam(name = "from", required = false) String fromDate,
                                @RequestParam(name = "to", required = false) String toDate,
                                @RequestParam(name = "interval", required = false) String interval
    ) {

    if (StringUtils.isEmpty(fromDate) || StringUtils.isEmpty(toDate))
      return stockInfoService.getStock(symbol, includeHist);


    return stockInfoService.getHistorical(symbol, fromDate, toDate, Interval.valueOf(interval));
  }



}
