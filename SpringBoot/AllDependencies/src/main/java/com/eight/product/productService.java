package com.eight.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class productService
{
	private productDAO pd;
	
	@Autowired
	public productService(productDAO pd)
	{
		super();
		System.out.println("Step "+A.StepCount()+" >>> "+"productService parameterised constructor entered");
		this.pd = pd;
		System.out.println("Step "+A.StepCount()+" >>> "+"productService parameterised constructor exited");
	}

	public productService()
	{
		System.out.println("Step "+A.StepCount()+" >>> "+"productService default constructor entered");
		System.out.println("Step "+A.StepCount()+" >>> "+"productService default constructor exited");
	}

	public productDAO getPd()
	{
		return pd;
	}

	public void setPd(productDAO pd)
	{
		this.pd = pd;
	}
	
	
}
