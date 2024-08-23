package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class engine
{	
	
	private int i;
	
	
	@Autowired
	public engine(@Qualifier("getInt2") int i)
	{	
		this.i = i;
		System.out.println("\nengine parameter constructor called\n");
	}
	
//	public engine()
//	{
//		System.out.println("\nengine default's constructor called\n");
//	}
	
	public void start()
	{
		System.out.println("Engine started");
	}
}
