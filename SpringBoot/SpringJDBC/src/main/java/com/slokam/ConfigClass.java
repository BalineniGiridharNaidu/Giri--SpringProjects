package com.slokam;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@ComponentScan("com.slokam")
public class ConfigClass
{	
	@Bean
	public DataSource getDataSource()
	{	
		System.out.println("========= beginning of getDataSource() =========");
		BasicDataSource dataSource = new BasicDataSource();
		// database credentials
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@1234");
		System.out.println("getDataSource() -------------->>>>>>>>>> "+dataSource);
		System.out.println("============ end of getDataSource() ================");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemp()
	{	
		DataSource ds = getDataSource();
		System.out.println("getJdbcTemp() -------------->>>>>>>>>> "+ds);
		return new JdbcTemplate(ds);
	}
	
}
