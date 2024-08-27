package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class pController
{	
	
	@Autowired
	private pservice ps;
	
	public void getProductByid(int pid)
	{
		ps.getProductByid(pid);
	}
	
	public void delete_by_Id_Name(int pid)
	{
		ps.delete_by_Id_Name(pid);
	}
	
	public void saveWith_NamedParameterJdbcTemplate_Reading_From_File(String path)
	{
		ps.saveWith_NamedParameterJdbcTemplate_Reading_From_File(path);
	}
	
	public void saveWithNamedParameterJdbcTemplate(productPojo p)
	{
		ps.saveWithNamedParameterJdbcTemplate(p);
	}
	
	public void getAggregatorsById()
	{
		ps.getAggregatorsById();
	}
	
	public void getAll4()
	{
		ps.getAll4();
	}
	
	public void getAll3()
	{
		ps.getAll3();
	}
	
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
