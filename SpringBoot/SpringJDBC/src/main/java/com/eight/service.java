package com.eight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * receives  requests and diverts the requests to the Data Access Object layer
 */
@Component
public class service
{	
	@Autowired
	private dao d;
	
	//@Autowired
	public service(dao d)
	{
		System.out.println("Step "+A.count() +" >> "+ "service constructor entered");
		this.d = d;
		System.out.println("Step "+A.count() +" >> "+ "service constructor exited");
	}
	
	
	@Autowired
	public void setD(dao d)
	{	
		System.out.println("Step "+A.count() +" >> "+"service setter method start");
		this.d = d;
		System.out.println("Step "+A.count() +" >> "+"service setter method end");
	}

	public service()
	{
		System.out.println("Step "+A.count() +" >> " +" service default constructor entered");
		System.out.println("Step "+A.count() +" >> " +" service default constructor exited");
	}
	
	public void save(emp e)
	{
		System.out.println("Step "+A.count() +" >> "+"service saving started");
		d.save(e);
		System.out.println("Step "+A.count() +" >> "+"service saving exited");
	}
}
