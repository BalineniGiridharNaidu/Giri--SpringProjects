package com.eight.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class productController
{
	private productService ps;
	
	@Autowired
	public productController(productService ps)
	{
		super();
		System.out.println("Step "+A.StepCount()+" >>> "+"productController parameterised constructor entered");
		this.ps = ps;
		System.out.println("Step "+A.StepCount()+" >>> "+"productController parameterised constructor exited");
	}

	public productController()
	{
		System.out.println("Step "+A.StepCount()+" >>> "+"productController default constructor entered");
		System.out.println("Step "+A.StepCount()+" >>> "+"productControllerss default constructor exited");
	}

	public productService getPs()
	{
		return ps;
	}

	public void setPs(productService ps)
	{
		this.ps = ps;
	}
	
	
}
