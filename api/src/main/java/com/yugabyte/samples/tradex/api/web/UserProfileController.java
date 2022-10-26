package com.yugabyte.samples.tradex.api.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yugabyte.samples.tradex.api.model.AppUser;
import com.yugabyte.samples.tradex.api.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserProfileController {

  @Autowired
  UserProfileService profileService;

  @GetMapping("/api/user/profile/{emailId}")
  public AppUser getUserProfile(@PathVariable("emailId") String emailId) {
    return profileService.fetchUserByEmail(emailId);
  }

  @PostMapping(value = "/api/user/profile", consumes = MediaType.APPLICATION_JSON_VALUE)
  public AppUser createUserProfile(AppUser newAppUser){
    try {
      return profileService.insertUser(newAppUser);
    } catch (JsonProcessingException e) {
      log.error("Failed to parse json");
      e.printStackTrace();
    }
    return null;
  }
}
