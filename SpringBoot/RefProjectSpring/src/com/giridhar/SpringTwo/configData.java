package com.giridhar.SpringTwo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.giridhar.SpringTwo")
public class configData
{	
	
//	@Bean
//	public developer d1()
//	{	
//		//System.out.println(" developer d1 bean method called");
//		return new developer();
//	}
//	
//	@Bean
//	public manager m1()
//	{	
//		//System.out.println(" developer d1 bean method called");
//		return new manager();
//	}
//	
//	@Bean
//	public teamlead t1()
//	{	
//		//System.out.println(" developer d1 bean method called");
//		return new teamlead();
//	}
	
	
	@Bean(name = "b1")
	public String getString1()
	{
		return "Hello String1111111111111111!!!";
	}
	
	@Bean(name = "b2")
	public String getString2()
	{
		return "Hello String222222222222222222!!!";
	}
	
	@Bean(name = "b3")
	public String getString3()
	{
		return "Hello String3333333333333333333333!!!";
	}
	
	
}
