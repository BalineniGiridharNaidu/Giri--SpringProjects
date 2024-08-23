package com.eight;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Manages all database logic
 */
@Component
public class dao
{	
	
	private DataSource ds;
	
	@Autowired
	private JdbcTemplate temp;
	
	@Autowired
	public dao(DataSource ds)
	{
		System.out.println("Step "+A.count() +" >> "+ "dao  parameter constructor entered");
		this.ds = ds;
		System.out.println("Step "+A.count() +" >> "+ "dao parameter constructor exited");
	}
	
	//@Autowired
	public void setDs(DataSource ds)
	{	
		System.out.println("Step "+A.count() +" >> "+"dao setter method start");
		this.ds = ds;
		System.out.println("Step "+A.count() +" >> "+"dao setter method start");
	}


	public dao()
	{
		System.out.println("Step "+A.count() +" >> "+ "dao  default constructor entered");
		System.out.println("Step "+A.count() +" >> "+ "dao default constructor exited");
	}
	
	public void save(emp e)
	{
		System.out.println("Step "+A.count() +" >> "+"dao saving started");
		temp.update("insert into spring_jdbc.emp values (?,?,?);", e.getEid(), e.getEname(), e.getEsal());
		System.out.println("Step "+A.count() +" >> "+"dao saving exited");
	}
}
