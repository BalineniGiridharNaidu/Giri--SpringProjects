package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class pController
{	
	
	@Autowired
	private pservice ps;
	
	public void getAll2()
	{
		ps.getAll2();
	}
	
	public void getById(int id)
	{
	    ps.getById(id);
	}
	
	public void deleteById(int pid)
	{
		ps.deleteById(pid);
	}
	
	public void updateProductNameById(int pid, String name)
	{
		ps.updateProductNameById(pid, name);
	}
	
	public void updateProductPriceById(int pid, double price)
	{
		ps.updateProductPriceById(pid, price);
	}
	
	public void updateProductGstById(int pid, double gst)
	{
		ps.updateProductGstById(pid, gst);
	}
	
	public void updateProductTypeById(int pid, String type)
	{
		ps.updateProductTypeById(pid, type);
	}
	
	public void saveBatchdataThroughJdbcTemplateFromFile(String path)
	{
		ps.saveBatchdataThroughJdbcTemplateFromFile(path);
	}
	
	public void saveWithJdbctemplate(productPojo p)
	{
		ps.saveWithJdbctemplate(p);
	}
	
	public void saveWithDataSource(productPojo p)
	{
		ps.saveWithDataSource(p);
	}
	
	public void createTable(String sqlQuery)
	{
		ps.createTable(sqlQuery);
	}
	
	public void createDataBase(String name)
	{
		ps.createDataBase(name);
	}
	
	public void save(productPojo p)
	{
		ps.save(p);
	}
}
