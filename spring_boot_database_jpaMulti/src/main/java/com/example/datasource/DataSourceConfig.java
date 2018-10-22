
package com.example.datasource;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DataSourceConfig {

	@Bean(name="primaryDataSource")	
	@Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.primary")
	@Primary
	public DataSource primaryDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="secondDataSource")	
	@Qualifier("secondDataSource")
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource secondDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "primaryJdbcTemplate")
    public NamedParameterJdbcTemplate primaryJdbcTemplate(
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "secondJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
