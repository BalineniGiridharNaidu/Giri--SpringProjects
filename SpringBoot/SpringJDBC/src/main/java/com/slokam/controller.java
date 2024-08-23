package com.slokam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class controller
{	
	
	
	@Autowired
	private service s;
	
	public void saveByJdbcTemplate(empPojo e)
	{
		System.out.println("controller saveByJdbcTemplate saving started");
		s.saveByJdbcTemplate(e);
		System.out.println("controller saveByJdbcTemplate saving completed");
	}
	
	public void updateById(int eid)
	{
		s.updateById(eid);
	}
	
	public void AddListOfEmpFromReadingTextFileWithBATCH_COMMAND(String path)
	{
		s.AddListOfEmpFromReadingTextFileWithBATCH_COMMAND(path);
	}
	
	public void AddListOfEmpFromReadingTextFile(String path)
	{
		s.AddListOfEmpFromReadingTextFile(path);
	}
	
	public void getMinSalEmp()
	{
		s.getMinSalEmp();
	}
	
	public void getMaxSalEmp()
	{
		s.getMaxSalEmp();
	}
	
	public void getAllDESC()
	{
		s.getAllDESC();
	}
	
	public void getAllASC()
	{
		s.getAllASC();
	}

	
	public void getAll()
	{
		System.out.println("Get all ops started in datasource");
		s.getAll();
		System.out.println("Get all ops ended in datasource");
	}
	
	public void searchByLastLetter(String a )
	{
		System.out.println("Search by last letter controller started");
		s.searchByLastLetter(a);
		System.out.println("Search by last letter controller ended");
	}
	
	public void searchByFirstLetter(String a )
	{	
		System.out.println("searchByFirstLetter controller started");
		s.searchByFirstLetter(a);
		System.out.println("searchByFirstLetter controller ended");
	}
	
	public void save(empPojo e)
	{
		System.out.println("controller saving started");
		s.save(e);
		System.out.println("controller saving completed");
	}
	
	public void getById(int eid)
	{	 
		System.out.println("controller getById started");
		s.getById(eid);
		System.out.println("controller getById completed");
		
	}
	
	public void searchByName(String ename)
	{
		System.out.println("Controller name search started");
		s.searchByName(ename);
		System.out.println("Controller name search completed");
	}
}
