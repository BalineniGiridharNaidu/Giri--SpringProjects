package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class pservice
{	
	@Autowired
	private pDao da;
	
	public void getAll2()
	{
		da.getAll2();
	}
	
	public void getById(int id)
	{
	    da.getById(id);
	}
	
	public void deleteById(int pid)
	{
		da.deleteById(pid);
	}
	
	public void updateProductNameById(int pid, String name)
	{
		da.updateProductNameById(pid, name);
	}
	
	public void updateProductPriceById(int pid, double price)
	{
		da.updateProductPriceById(pid, price);
	}
	
	public void updateProductGstById(int pid, double gst)
	{
		da.updateProductGstById(pid, gst);
	}
	
	public void updateProductTypeById(int pid, String type)
	{
		da.updateProductTypeById(pid, type);
	}
	
	public void saveBatchdataThroughJdbcTemplateFromFile(String path)
	{
		da.saveBatchdataThroughJdbcTemplateFromFile(path);
	}
	
	public void saveWithJdbctemplate(productPojo p)
	{
		da.saveWithJdbctemplate(p);
	}
	
	
	public void saveWithDataSource(productPojo p)
	{
		da.saveWithDataSource(p);
	}
	
	public void createTable(String sqlQuery)
	{
		da.createTable(sqlQuery);
	}
	
	public void createDataBase(String name)
	{
		da.createDataBase(name);
	}
	
	
	public void save(productPojo p)
	{
		da.save(p);
	}
}
