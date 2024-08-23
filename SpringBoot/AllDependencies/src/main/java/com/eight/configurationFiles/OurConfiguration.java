package com.eight.configurationFiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.eight.componentClasses.tractor;
import com.eight.componentClasses.trolley;

@Configuration
@ComponentScan("com.eight.componentClasses")
public class OurConfiguration
{	
	@Bean
	public tractor m1()
	{
		return new tractor();
	}
	
	@Bean
	public trolley m2()
	{
		return new trolley();
	}
}
