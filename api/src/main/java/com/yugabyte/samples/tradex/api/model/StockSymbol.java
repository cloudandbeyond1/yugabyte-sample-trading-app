package com.yugabyte.samples.tradex.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StockSymbol {
  String code;
  String name;
}
