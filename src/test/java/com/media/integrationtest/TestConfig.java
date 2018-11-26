package com.media.integrationtest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages={"com.media.service"})
@PropertySource("classpath:application.properties")
public class TestConfig {

}
