package com.eight.product;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("com.eight.product")
public abstract class ConfigFile
{
	
	public ConfigFile()
	{
		System.out.println("Step "+A.StepCount()+" >>> "+"ConfigFile default constructor entered");
		System.out.println("Step "+A.StepCount()+" >>> "+"ConfigFile default constructor exited");
	}
	
	@Bean
	public BasicDataSource getDataSource()
	{	
		System.out.println("Step "+A.StepCount()+" >>> "+"getDataSource() method entered");
		BasicDataSource ds = new BasicDataSource();
		
		//database credentials
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("Root@1234");
		ds.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		
		//connection pool configuration
		ds.setInitialSize(5);
		ds.setMaxWaitMillis(5000);
		
		System.out.println("Step "+A.StepCount()+" >>> "+"getDataSource() method exited");
				
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate()
	{	
		System.out.println("Step "+A.StepCount()+" >>> "+"getJdbcTemplate() method entered");
		BasicDataSource ds = getDataSource();
		System.out.println(ds);
		System.out.println("Step "+A.StepCount()+" >>> "+"getJdbcTemplate() method exited");
		return new JdbcTemplate(ds);
	}
	
	
	public DataSource A()
	{
		return getDataSource();
	}
	
//	@Bean(name = "abstract")
//	public abstract DataSource B();
	
}
