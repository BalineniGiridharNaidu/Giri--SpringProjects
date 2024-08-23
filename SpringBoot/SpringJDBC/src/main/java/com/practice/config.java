package com.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.practice")
public class config
{	
	@Bean(name = "integer1")
	public int getInt()
	{	
		System.out.println("integer 1 method");
		return 1;
	}
	
	@Bean
	public int getInt2()
	{	
		System.out.println("integer 2 method");
		return 1;
	}
}
