package com.product;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ComponentScan("com.product")
public class pConfig
{	
	@Bean(name = "DataSource")
	public DataSource getDataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		
		//database credentials
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/giri");
		ds.setUsername("root");
		ds.setPassword("Root@1234");
		
		//connection pooling configuration
		
		ds.setInitialSize(5); // initially 5 connection objects will be there
		ds.setMaxTotal(10); // Maximum connection objects is 10
		ds.setMaxWaitMillis(1); // A thread will wait for 5 seconds
		// before it throws an exceptionsss
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbctemplate()
	{
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate()
	{
		return new NamedParameterJdbcTemplate(getDataSource());
	}
	
	
}
