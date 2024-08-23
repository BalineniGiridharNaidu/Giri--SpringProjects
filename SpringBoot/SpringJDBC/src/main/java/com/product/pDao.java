package com.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class pDao
{	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private JdbcTemplate temp;
	
	
	
	public void getAll2()
	{
		//productPojo v = temp.queryForObject("select * from giri.product", new BeanPropertyRowMapper<productPojo>(productPojo.class));
		List<productPojo> v = temp.query("select * from giri.product", new BeanPropertyRowMapper(productPojo.class));
		System.out.println(v);
	}
	
	public void getAll1()
	{
		productPojo v = temp.queryForObject("select * from giri.product where pid = ?", new BeanPropertyRowMapper<productPojo>(productPojo.class), 3);
		System.out.println(v);
	}
	
	public void getById(int id)
	{
	   String name = temp.queryForObject("select pname from giri.product where pid = ?", String.class, id);
	   System.out.println(name);
	   System.out.println("-------------------------------------------------");
	   try {
	   String name1 = (String) temp.queryForObject("select pname from giri.product where pid = ?", Class.forName("java.lang.String"), id);
	   System.out.println(name1);
	   }catch(Exception e) { e.printStackTrace(); }
	   System.out.println("-------------------------------------------------");
	   
	   String name2 = temp.queryForObject("select pname from giri.product where pid = ?", new Object[]{ id } , String.class);
	   System.out.println(name2);
	   
	}
	
	public void deleteById(int pid)
	{
		int rows = temp.update("delete from giri.product where pid = ?", pid);
		System.out.println("Number of rows deleted is "+ rows);
	}
	
	public void updateProductNameById(int pid, String name)
	{
		int rows = temp.update("update giri.product set pname = ? where pid = ?",name, pid);
		System.out.println("Number of rows affected is "+ rows);
	}
	
	public void updateProductPriceById(int pid, double price)
	{
		int rows = temp.update("update giri.product set pprice = ? where pid = ?",price, pid);
		System.out.println("Number of rows affected is "+ rows);
	}
	
	public void updateProductGstById(int pid, double gst)
	{
		int rows = temp.update("update giri.product set pgst = ? where pid = ?",gst, pid);
		System.out.println("Number of rows affected is "+ rows);
	}
	
	public void updateProductTypeById(int pid, String type)
	{
		int rows = temp.update("update giri.product set ptype = ? where pid = ?", type, pid);
		System.out.println("Number of rows affected is "+ rows);
	}
	
	
	public void save(productPojo p)
	{
		System.out.println("DAO saving operation started");
		int r =temp.update("insert into giri.product values (?,?,?,?,?)", p.getPid(),p.getPname(),p.getPprice(),p.getPgst(),p.getPtype());
		System.out.println("Number of rows affected is "+ r);
		System.out.println("DAO saving operation ended");
	}
	
	
	public void saveBatchdataThroughJdbcTemplateFromFile(String path)
	{	
		List<Object[]> data = new ArrayList<>();
		
		List<productPojo> pinfo = readDataFromFile(path);
		if(pinfo.size() == 0)
		{
			System.out.println("The given file is empty.......");
		}
		else
		{
		
			for(productPojo m : pinfo)
			{
				Object[] A = { m.getPid(), m.getPname(), m.getPprice(), m.getPgst(), m.getPtype() };
				data.add(A);
			}
			
			// Now list of object arrays is ready and saved into the database
			
			int[] r = temp.batchUpdate("insert into giri.product values (?,?,?,?,?);", data);
			System.out.println("Data saved successfully");
			
			for(int i : r)
			{
				System.out.println(i);
			}
			
		}	
	}
	
	public List<productPojo> readDataFromFile(String path)
	{	
		List<productPojo> data = new ArrayList<>();
		
		try
			(
				FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);
			)
		{
			String line = br.readLine();
			if(line == null)
				System.out.println("The provided file is empty");
			while(line != null)
			{	
				String[]  n = line.split(",");
				productPojo p = new productPojo();
				p.setPid(Integer.parseInt(n[0]));
				p.setPname(n[1]);
				p.setPprice(Double.parseDouble(n[2]));
				p.setPgst(Double.parseDouble(n[3]));
				p.setPtype(n[4]);
				
				data.add(p);
				
				line = br.readLine();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	
	public void saveWithJdbctemplate(productPojo p)
	{
		int r = temp.update("insert into giri.product values (?,?,?,?,?);", p.getPid(),p.getPname(),p.getPprice(),p.getPgst(),p.getPtype());
		System.out.println("Saved the data Jdbctemplate successfully, rows affected is "+ r);
	}
	
	public void saveWithDataSource(productPojo p)
	{
		//query
		String iq = "insert into giri.product values (?,?,?,?,?);";
		
		try
		   (// try with resources declaration, write classes which implements the Auto-closeable interface
		      Connection con = ds.getConnection(); 
			  PreparedStatement ps = con.prepareStatement(iq)
		   )	
		{	
			// Mapping product variables to the table columns
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPname());
			ps.setDouble(3, p.getPprice());
			ps.setDouble(4, p.getPgst());
			ps.setString(5, p.getPtype());
			
			int rows = ps.executeUpdate();
			System.out.println("No of rows affected is "+ rows);
		}
		catch(Exception e)
		{
			System.out.println("Dao saveWithDataSource(productPojo p) catch block executed");
			e.printStackTrace();
		}
		//try block
		//execute
		
	}
	
	public void createTable(String sqlQuery)
	{
		try(Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sqlQuery))
		{
			ps.execute();
			System.out.println("table created successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
//	public void save(productPojo p)
//	{	
//		String q = "insert into giri.product values (?,?,?,?,?);";
//		
//		try(     // try with resources declaration
//				Connection con = ds.getConnection();// ---> link between java and database
//				PreparedStatement ps = con.prepareStatement(q) // ---> behaviour of connection object is statement
//			)
//		{
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	public void createDataBase(String name)
	{	
		String q = "create schema giri";
		try( Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(q); )
		{
			ps.execute();
			System.out.println("---------------");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
}
