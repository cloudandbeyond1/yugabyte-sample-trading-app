package com.yugabyte.samples.tradex.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppUser {
  int id;
  String email;
  String password;
  boolean enabled;
  PersonalDetails personalDetails;
  UserPreferences preferences;
  String preferredRegion;
}
