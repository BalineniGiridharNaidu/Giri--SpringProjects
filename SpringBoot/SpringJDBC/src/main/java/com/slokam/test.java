package com.slokam;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test
{
	public static void main(String[] args) throws ClassNotFoundException
	{	
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(ConfigClass.class);
		
		controller c = ioc.getBean(controller.class);
		
		c.saveByJdbcTemplate(new empPojo(25, "Shukla", 24, 79000.23));
		
		ioc.close();
		
		
	}
}
