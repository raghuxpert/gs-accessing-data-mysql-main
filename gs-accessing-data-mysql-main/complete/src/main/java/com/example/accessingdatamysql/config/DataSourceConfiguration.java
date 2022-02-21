//package com.example.accessingdatamysql.config;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfiguration {
//    @Bean
//    @Primary
//    @ConfigurationProperties("user.datasource")
//    public DataSourceProperties fooDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @Primary
//    @ConfigurationProperties("user.datasource")
//    public DataSource fooDataSource() {
//        return fooDataSourceProperties().initializeDataSourceBuilder().build();
//    }
//
//    @Bean
//    @ConfigurationProperties("city.datasource")
//    public DataSourceProperties barDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @ConfigurationProperties("city.datasource")
//    public DataSource barDataSource() {
//        return barDataSourceProperties().initializeDataSourceBuilder().build();
//    }
//}
