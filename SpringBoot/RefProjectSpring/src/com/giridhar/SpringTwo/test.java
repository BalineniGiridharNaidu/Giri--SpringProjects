package com.giridhar.SpringTwo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test
{
	public static void main(String[] args)
	{
		ApplicationContext sc = new AnnotationConfigApplicationContext(configData.class);
		
		String[] bn = sc.getBeanDefinitionNames();
		
		for(String s : bn )
		{
			System.out.println(s);
		}
		
		
//		 manager m = sc.getBean(manager.class);
//		 m.doWork();
//		 
//		 developer d = new developer();
//		 
//		 teamlead tl = new teamlead();
//		 
//		 tl.setDev(d);
//		 
//		 m.setTl(tl);
//		 
//		 m.doWork();
		
//		String s = (String) sc.getBean("b3");
//		System.out.println(s); 
		 
	}
}
