package com.yugabyte.samples.tradex.api.repo;

import com.yugabyte.samples.tradex.api.model.AppUser;
import com.yugabyte.samples.tradex.api.model.AppUserId;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "appUser")
@OpenAPIDefinition()
public interface AppUserRepository extends JpaRepository<AppUser, AppUserId> {
  public AppUser findByEmail(String email);

}
