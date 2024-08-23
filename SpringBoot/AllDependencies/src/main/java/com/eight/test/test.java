package com.eight.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eight.componentClasses.tractor;
import com.eight.configurationFiles.OurConfiguration;





public class test
{

	public static void main(String[] args)
	{	
		
		
		AnnotationConfigApplicationContext iocContainer = new AnnotationConfigApplicationContext(OurConfiguration.class);
		
		int c = iocContainer.getBeanDefinitionCount();
		System.out.println(c);
		System.out.println("--------------------");
		String[] names = iocContainer.getBeanDefinitionNames();
		for(String bean : names)
		{
			System.out.println(bean);
		}
		System.out.println();
		iocContainer.getBean(tractor.class).start();
		
		
		iocContainer.close();
		
	}

}
