package com.student;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(sConfig.class);
		System.out.println("Spring ioc container is --- "+ioc);
		
		scontroller sc = ioc.getBean(scontroller.class);
		
		sc.UpdateCourseByNamedParameterJdbcTemplateById(5, "Degree");
		
		ioc.close();
	}
}
