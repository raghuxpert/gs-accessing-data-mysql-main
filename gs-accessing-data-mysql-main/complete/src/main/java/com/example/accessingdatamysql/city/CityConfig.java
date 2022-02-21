package com.example.accessingdatamysql.city;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "cityEntityManagerFactory",
        transactionManagerRef = "cityTransactionManager",
        basePackages = { "com.example.accessingdatamysql.city" }
)
public class CityConfig {
    @Bean(name = "cityDataSource")
    @ConfigurationProperties(prefix = "city.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cityEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    cityEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("cityDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.accessingdatamysql.city")
                .persistenceUnit("City")
                .build();
    }

    @Bean(name = "cityTransactionManager")
    public PlatformTransactionManager cityTransactionManager(
            @Qualifier("cityEntityManagerFactory") EntityManagerFactory
                    cityEntityManagerFactory
    ) {
        return new JpaTransactionManager(cityEntityManagerFactory);
    }
}
