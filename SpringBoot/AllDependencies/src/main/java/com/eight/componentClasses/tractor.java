package com.eight.componentClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class tractor
{	
	@Autowired
	private trolley t;
	
	public void start()
	{	
		t.start();
		System.out.println("Tractor started and moving........");
	}
}
