package com.yugabyte.samples.tradex.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartupTask implements CommandLineRunner {

  @Autowired
  JdbcTemplate jdbcTemplate;

  final String CHECK_SQL = "select count(*) from REF_DATA";
  @Override
  public void run(String... args) throws Exception {
    log.info("Application started. Number of REF_DATA entries: " + jdbcTemplate.queryForObject(CHECK_SQL, Integer.class));
  }
}
