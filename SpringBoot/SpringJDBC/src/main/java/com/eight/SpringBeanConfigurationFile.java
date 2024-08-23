package com.eight;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("com.eight")
public class SpringBeanConfigurationFile
{
	public SpringBeanConfigurationFile()
	{
		System.out.println("Step "+A.count() +" >> "+ "SpringBeanConfigurationFile constructor entered");
		System.out.println("Step "+A.count() +" >> "+ "SpringBeanConfigurationFile constructor exited");
	}
	
	
	@Bean
	public BasicDataSource getDataSource()
	{	
		System.out.println("Step "+A.count() +" >> "+ "getDataSource() entered");
		BasicDataSource ds = new BasicDataSource();
		
		//database credentials
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("Root@1234");
		ds.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		
		//connection pool configuration
		ds.setInitialSize(5);
		ds.setMaxWaitMillis(5000);
		System.out.println("Step "+A.count() +" >> "+ "getDataSource() exited");
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate()
	{	
		System.out.println("Step "+A.count() +" >> "+ "getJdbcTemplate() entered");
		System.out.println("Step "+A.count() +" >> "+ "getJdbcTemplate() exited");
		return new JdbcTemplate(getDataSource());
	}
}
