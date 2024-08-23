package com.eight.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class productDAO
{
	private JdbcTemplate jtp;
	
	@Autowired
	public productDAO(JdbcTemplate jtp)
	{
		super();
		System.out.println("Step "+A.StepCount()+" >>> "+"productDAO parameterised constructor entered");
		this.jtp = jtp;
		System.out.println("Step "+A.StepCount()+" >>> "+"productDAO parameterised constructor exited");
	}

	public productDAO()
	{
		System.out.println("Step "+A.StepCount()+" >>> "+"productDAO default constructor entered");
		System.out.println("Step "+A.StepCount()+" >>> "+"productDAO default constructor exited");
	}

	public JdbcTemplate getJtp()
	{
		return jtp;
	}

	public void setJtp(JdbcTemplate jtp)
	{
		this.jtp = jtp;
	}
	
	public void getAll()
	{	
		
	}
	
	
}
