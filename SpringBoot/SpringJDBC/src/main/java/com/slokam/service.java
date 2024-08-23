package com.slokam;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class service
{	
	@Autowired
	private dao da;
	
	
	public void saveByJdbcTemplate(empPojo e)
	{
		System.out.println("service saveByJdbcTemplate saving started");
		da.saveByJdbcTemplate(e);
		System.out.println("service saveByJdbcTemplate saving completed");
	}
	
	public void updateById(int eid)
	{
		da.updateById(eid);
	}
	
	public void AddListOfEmpFromReadingTextFileWithBATCH_COMMAND(String path)
	{
		da.AddListOfEmpFromReadingTextFileWithBATCH_COMMAND(path);
	}
	
	public void AddListOfEmpFromReadingTextFile(String path)
	{
		da.AddListOfEmpFromReadingTextFile(path);
	}
	
	public void getMinSalEmp()
	{
		da.getMinSalEmp();
	}
	
	public void getMaxSalEmp()
	{
		da.getMaxSalEmp();
	}

	
	public void getAllDESC()
	{
		da.getAllDESC();
	}

	
	public void getAllASC()
	{
		da.getAllASC();
	}
	
	public void getAll()
	{
		System.out.println("Get all ops started in datasource");
		da.getAll();
		System.out.println("Get all ops ended in datasource");
	}
	
	public void searchByLastLetter(String a )
	{
		System.out.println("Search by last letter service started");
		da.searchByLastLetter(a);
		System.out.println("Search by last letter service ended");
	}
	
	
	public void searchByFirstLetter(String a )
	{	
		System.out.println("searchByFirstLetter service started");
		da.searchByFirstLetter(a);
		System.out.println("searchByFirstLetter service ended");
	}
	
	public void searchByName(String ename)
	{
		System.out.println("service name search started");
		da.searchByName(ename);
		System.out.println("service name search completed");
	}
	
	public void save(empPojo e)
	{
		System.out.println("Service saving started");
		da.save(e);
		System.out.println("Service saving completed");
	}
	
	public void getById(int eid)
	{
		System.out.println("service getById started");
		da.getById(eid);
		System.out.println("service getById completed");
	}
}
