package com.eight.product;



import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test
{	
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(ConfigFile.class);
		 ConfigFile cfg = ioc.getBean(ConfigFile.class);
		 System.out.println("----------------------");
		 System.out.println( cfg.getJdbcTemplate() );
		 System.out.println("----------------------");
		 System.out.println( cfg.getJdbcTemplate() );
	}
	
	
	
	
	public static void main1(String[] args)
	{
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(ConfigFile.class);
		System.out.println(ioc);
		
        String[] names = ioc.getBeanDefinitionNames();
		
		for(String s : names)
		{
			System.out.println(s);
		}
		
		
		ConfigFile con = ioc.getBean(ConfigFile.class);
		System.out.println();
		System.out.println("Data Source object through A call is "+ con.A());
		//System.out.println("Data Source object through B call is "+ con.B());
		
		System.out.println();
		System.out.println("Data Source object through container bean  is "+ ioc.getBean(BasicDataSource.class));
		System.out.println();
		System.out.println("---------------------------------------------------");
		
	}
}
