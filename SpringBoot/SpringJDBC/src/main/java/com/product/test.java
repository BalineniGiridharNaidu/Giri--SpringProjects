package com.product;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class test
{	
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(pConfig.class);
		
		pDao pc = ioc.getBean(pDao.class);
		
		pc.getAll2();
		
		
		
//		pc.save(new productPojo(8, "butterscotch", 123.456, 20.98, "icecream"));
	}
	
	
//	public static void main1(String[] args)
//	{
//		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(pConfig.class);
//		
//		pController pc = ioc.getBean(pController.class);
//		
//	    pc.saveBatchdataThroughJdbcTemplateFromFile("./product_info2.txt");
//		
//		 
//		ioc.close();
//	}
}
