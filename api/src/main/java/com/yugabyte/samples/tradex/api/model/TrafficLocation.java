package com.yugabyte.samples.tradex.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrafficLocation {
  int id;
  String name;
  String country;
  String latitude;
  String longitude;
}
