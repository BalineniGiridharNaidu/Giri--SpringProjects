package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class car
{	
	@Autowired
	private engine e;
	
	@Autowired
	public car(engine e)
	{
		super();
		System.out.println(e);
		System.out.println("\ncar parameter constructor called\n");
		this.e = e;
	}

	@Autowired
	public void setE(engine e)
	{	
		System.out.println(e);
		System.out.println("\nCars set engine method called\n");
		this.e = e;
	}

	public car()
	{
		System.out.println("\ncar default's constructor called\n");
	}
	
	public void start()
	{
		System.out.println("car is starting");
		e.start();
		System.out.println("Car starting completed ");
	}
}
