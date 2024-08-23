package com.practice;



import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

 public class BasicDataSourceExample
{	
	private BasicDataSource ds = getDataSource();
	
	public static void main(String[] args) throws Exception
	{
		BasicDataSourceExample b = new BasicDataSourceExample();
		
		for(int i=1; i<=10; i++)
		{
			Runnable r = ()->{ try
			{
				b.getConnection();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} };
			Thread t = new Thread(r);
			t.start();
			Thread.sleep(1000);
		}
		
		System.out.println("Loop exited");
		
		
		
	}
	
	public BasicDataSource getDataSource()
	{	
		BasicDataSource dataSource = new BasicDataSource();
		//database credentials
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_BasicDataSource");
        dataSource.setUsername("root");
        dataSource.setPassword("Root@1234");
		
        //pooling configuration
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		dataSource.setMaxWaitMillis(10);
		
		return dataSource;
	}
	
	public synchronized Connection getConnection() throws Exception
	{	
		System.out.println(Thread.currentThread().getName() + " entered");
		
		synchronized (ds)
		{
			System.out.println(Thread.currentThread().getName());
			System.out.println("connection objects in active state --" + ds.getNumActive());
			System.out.println("connection objects in idle state --" + ds.getNumIdle());
		}
		
		
		
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		try
		{
			con = ds.getConnection();
		}
		catch(Exception e)
		{
			System.out.println(Thread.currentThread().getName() + " exception thrown");
			throw e;
		}
		
		
		System.out.println(Thread.currentThread().getName() + " exited");
		return con;
	}
	
	
}
