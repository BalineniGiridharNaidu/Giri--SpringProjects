package com.eight.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class Starter
{
	public static void main(String[] args)
	{
		SpringApplication sp = new SpringApplication(Starter.class);
		//SpringBootApplication sp = new SpringApplication(Starter.class);
		sp.run();
	}
}
