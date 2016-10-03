package com.ar.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.ar.configuration.properties.DataConfigurationProperties;

@Configuration
@EnableConfigurationProperties(DataConfigurationProperties.class)
public class DataConfiguration {

}
