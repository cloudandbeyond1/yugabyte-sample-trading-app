package com.yugabyte.samples.tradex.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

  @Autowired
  Environment environment;

  @Autowired
  DataSource datasource;

  @Bean
  public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
    return new NamedParameterJdbcTemplate(datasource);
  }

  @Bean
  public JdbcTemplate jdbcTemplate(){
    return new JdbcTemplate(datasource);
  }

}
