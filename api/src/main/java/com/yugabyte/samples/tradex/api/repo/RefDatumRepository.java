package com.yugabyte.samples.tradex.api.repo;

import com.yugabyte.samples.tradex.api.model.RefDatum;
import com.yugabyte.samples.tradex.api.model.RefDatumId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RefDatumRepository extends JpaRepository<RefDatum, RefDatumId> {
  @Query("select r from RefDatum r where r.id.keyName = :keyName")
  RefDatum findByKeyName(@Param("keyName") String keyName);
}
