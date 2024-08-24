package com.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class pDao
{	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private JdbcTemplate temp;
	
	@Autowired
	private NamedParameterJdbcTemplate njtp;
	
	
	public void delete_by_Id_Name(int pid)
	{
		MapSqlParameterSource par = new MapSqlParameterSource();
		par.addValue("pid", pid);
		
		int r = njtp.update("delete from giri.product where pid >= :pid", par);
		System.out.println("No of rows deleted ---"+ r);
	}
	
	public void saveWith_NamedParameterJdbcTemplate_Reading_From_File(String path)
	{	
		List<productPojo> data = readDataFromFile(path);
		
		BeanPropertySqlParameterSource[] p = new BeanPropertySqlParameterSource[data.size()];
		
		for(int i = 0; i<data.size(); i++)
		{
		    BeanPropertySqlParameterSource n = new BeanPropertySqlParameterSource(data.get(i));
		    p[i] = n;
		}
		
		
		String query = "insert into giri.product values ( :pid, :pname, :pprice, :pgst, :ptype);";
		
		int[] vv = njtp.batchUpdate(query, p);
		System.out.println("No of rows --- "+ vv.length);
	}
	
	
	public void saveWithNamedParameterJdbcTemplate(productPojo p)
	{	
		Map<String, Object> map = new HashMap<>();
		//Mapping the named tags or labels to the product variables
		map.put("pid", p.getPid());
		map.put("pname", p.getPname());
		map.put("pprice", p.getPprice());
		map.put("pgst", p.getPgst());
		map.put("ptype", p.getPtype());
		
		
		int rows = njtp.update("insert into giri.product values ( :pid, :pname, :pprice, :pgst, :ptype);", map);
		
		System.out.println("No of rows affected --"+ rows);
	}
	
	
	public void getAggregatorsById()
	{
		Double maxOfPrice = temp.queryForObject("select max(pprice) from giri.product", Double.class);
		Double maxOfGst = temp.queryForObject("select max(pgst) from giri.product", Double.class);
		Double avgOfPrice = temp.queryForObject("select avg(pprice) from giri.product", Double.class);
		Double avgOfGst = temp.queryForObject("select avg(pgst) from giri.product", Double.class);
		Double minOfPrice = temp.queryForObject("select min(pprice) from giri.product", Double.class);
		Double minOfGst = temp.queryForObject("select min(pgst) from giri.product", Double.class);
		System.out.println("Max of price :"+ maxOfPrice);
		System.out.println("Min of price :"+ minOfPrice);
		System.out.println("Average of price :"+ avgOfPrice);
		System.out.println("---------------------------------------------------------");
		System.out.println("Max of gst :"+ maxOfGst);
		System.out.println("Min of gst :"+ minOfGst);
		System.out.println("Average of gst :"+ avgOfGst);
	}
		
	
	public void getAll4()
	{
//		List<Map<String, Object>> mapObjects = temp.queryForList("select * from giri.product");
//		System.out.println(mapObjects);
//		System.out.println("--------------------------");
		List<Map<String, Object>> mapObjects = temp.queryForList("select * from giri.product where pid in (?, ?, ?, ?) and pname like ?" , 2, 3, 5, 7, "%a%");
		System.out.println(mapObjects);
	}
	
	public void getAll3()
	{
		List<productPojo> v = temp.query("select * from giri.product", new GiriCustomRowMapper());
		System.out.println(v);
	}
	
	public void getAll2()
	{
		//productPojo v = temp.queryForObject("select * from giri.product", new BeanPropertyRowMapper<productPojo>(productPojo.class));
		// this is only works if column names of the table and properties of the class are same, so that beanpropertyrowmapper is used to mapped 
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
