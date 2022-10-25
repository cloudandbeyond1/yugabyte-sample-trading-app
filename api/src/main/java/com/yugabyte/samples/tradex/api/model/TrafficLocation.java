package com.yugabyte.samples.tradex.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrafficLocation {
  String name;
  String country;
  String latitude;
  String longitude;
}
