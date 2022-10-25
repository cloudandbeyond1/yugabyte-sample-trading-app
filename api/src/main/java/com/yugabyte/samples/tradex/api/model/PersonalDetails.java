package com.yugabyte.samples.tradex.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonalDetails {
  String firstName;
  String lastName;
  String address;
  String phone;
}
