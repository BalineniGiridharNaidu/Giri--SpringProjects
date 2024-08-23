package com.eight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handles requests and diverts the requests to the service layer
 */
@Component
public class controller
{	
	//@Autowired
	private service s;
	
	
	//@Autowired
	public controller(service s)
	{
		System.out.println("Step "+A.count() +" >> "+ " Controller constructor entered");
		this.s = s;
		System.out.println("Step "+A.count() +" >> "+ "Controller constructor exited");
	}
	
	@Autowired
	public void setS(service s)
	{
		System.out.println("Step "+A.count() +" >> "+"controller setter method start");
		this.s = s;
		System.out.println("Step "+A.count() +" >> "+"controller setter method end");
	}
	
	public controller()
	{
		System.out.println("Step "+A.count() +" >> "+"controller default constructor entered");
		System.out.println("Step "+A.count() +" >> " +"controller default constructor exited");
	}
	

	public void save(emp e)
	{
		System.out.println("Step "+A.count() +" >> "+"controller saving started");
		s.save(e);
		System.out.println("Step "+A.count() +" >> "+"controller saving exited");
	}
}
