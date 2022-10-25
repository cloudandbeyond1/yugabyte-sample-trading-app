package com.yugabyte.samples.tradex.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DBConfig.class)
public class AppConfig {
}
