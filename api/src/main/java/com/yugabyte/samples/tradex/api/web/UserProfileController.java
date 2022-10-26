package com.yugabyte.samples.tradex.api.web;

import com.yugabyte.samples.tradex.api.model.AppUser;
import com.yugabyte.samples.tradex.api.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserProfileController {

  @Autowired
  UserProfileService profileService;

  @GetMapping("/api/user/profile/{emailId}")
  public AppUser getUserProfile(@PathVariable("emailId") String emailId) {
    return profileService.findByEmail(emailId);
  }

}
