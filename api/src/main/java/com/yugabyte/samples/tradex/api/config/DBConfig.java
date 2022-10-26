package com.yugabyte.samples.tradex.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.yugabyte.samples.tradex.api.repo")
@ComponentScan(basePackages = { "com.yugabyte.samples.tradex.api" })
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

//  @Bean
//  public TransactionAwareDataSourceProxy transactionAwareDataSource() {
//    return new TransactionAwareDataSourceProxy(datasource);
//  }

  @Bean
  public DataSourceTransactionManager transactionManager() {
    return new DataSourceTransactionManager(datasource);
  }

//  @Bean
//  public DataSourceConnectionProvider connectionProvider() {
//    return new DataSourceConnectionProvider(datasource);
//  }
//
//
//
//  @Bean
//  public DefaultDSLContext dsl() {
//    return new DefaultDSLContext(configuration());
//  }
//  @Bean
//  public DefaultConfiguration configuration() {
//    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
//    jooqConfiguration.set(connectionProvider());
//    jooqConfiguration.set(new JooqExceptionTranslator());
//
//    //String sqlDialectName = environment.getRequiredProperty("jooq.sql.dialect");
////    SQLDialect dialect = SQLDialect.valueOf("Postgres");
////    jooqConfiguration.set(dialect);
//
//    return jooqConfiguration;
//  }

}
