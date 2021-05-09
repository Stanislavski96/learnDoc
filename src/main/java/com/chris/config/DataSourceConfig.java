package com.chris.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name="sellDataSource")
    @Qualifier("sellDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource sellDataSource(){
        return DataSourceBuilder.create().build();
    }


}
