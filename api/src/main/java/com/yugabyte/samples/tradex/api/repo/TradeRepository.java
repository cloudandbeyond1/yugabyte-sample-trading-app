package com.yugabyte.samples.tradex.api.repo;

import com.yugabyte.samples.tradex.api.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
