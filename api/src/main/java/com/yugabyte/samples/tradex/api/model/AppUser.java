package com.yugabyte.samples.tradex.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "app_user")
public class AppUser extends BaseEntity{
  @EmbeddedId
  private AppUserId id;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "password", nullable = false, length = 500)
  private String password;

  @Column(name = "enabled", nullable = false)
  private Boolean enabled = false;

  @Type(type = "json")
  @Column(name="personal_details", columnDefinition = "json")
  private PersonalDetails personalDetails;

  @Type(type = "json")
  @Column(name="preferences", columnDefinition = "json")
  private UserPreferences preferences;

}
