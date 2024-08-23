package com.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test
{
	public static void main(String[] args)
	{	
		//creation and initialisation of spring container
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(config.class);
		System.out.println(container);
		
		car c = container.getBean(car.class);
		c.start();
		
		System.out.println("------------------------------------------");
		String[]  list = container.getBeanDefinitionNames();
		for(String s : list)
		{
			System.out.println(s);
		}
	}
}
