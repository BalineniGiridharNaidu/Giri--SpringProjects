package com.product;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class test
{	
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(pConfig.class);
		
		pController pc = ioc.getBean(pController.class);
		
		//pc.saveWithNamedParameterJdbcTemplate(new productPojo(9, "Jijana", 45.99, 9.67, "Groceries"));
		
		//pc.saveWith_NamedParameterJdbcTemplate_Reading_From_File("./data.txt");
		
		//pc.delete_by_Id_Name(101);
		
		pc.getProductByid(4);
	}
		
}
