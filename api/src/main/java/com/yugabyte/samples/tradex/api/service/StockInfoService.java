package com.yugabyte.samples.tradex.api.service;

import com.yugabyte.samples.tradex.api.utils.DateUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@Slf4j
public class StockInfoService {

  @SneakyThrows
  public Stock getStock(String symbol, boolean includeHist) {
      return YahooFinance.get(symbol, includeHist);
  }

  @SneakyThrows
  public Map<String,Stock> fetchAllStocks(String[] symbols){
    return YahooFinance.get(symbols);
  }

  @SneakyThrows
  public Stock getHistorical(String symbol, String fromDate, String toDate, Interval interval) {
    try {
      return YahooFinance.get(symbol, DateUtils.fromYYYMMDD(fromDate), DateUtils.fromYYYMMDD(toDate), interval);
    }
    catch (ParseException e){
      log.error("Failed to parse dates");
    }
    throw new ApplicationServiceException("Failed to parse either from or to date using pattern YYYYMMDD. ");
  }

}
