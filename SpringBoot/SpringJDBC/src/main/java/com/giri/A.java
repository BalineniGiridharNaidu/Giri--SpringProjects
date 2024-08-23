package com.giri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A
{	
	@Autowired
	private B a;
	
	@Autowired
	public A(B a)
	{
		super();
		System.out.println("In  A parameterised const");
		this.a = a;
	}
	
	@Autowired
	public void setA(B a)
	{	
		System.out.println("In A setter method");
		this.a = a;
	}
	
}
