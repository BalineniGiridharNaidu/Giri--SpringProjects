package com.giri;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test
{

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(C.class);
		System.out.println(ioc);

	}

}
