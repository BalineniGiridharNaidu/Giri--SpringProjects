package com.eight;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test
{
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringBeanConfigurationFile.class);
		
		
		System.out.println();
		
		System.out.println(ioc.toString());
		
		
		
		controller con = ioc.getBean(controller.class);
		
		System.out.println();
		con.save(new emp(1, "Siva", 90000.89));
		System.out.println();
		
		ioc.close();
		System.out.println("Spring container destroyed");
	}
}
