package com.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class sDao
{	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private JdbcTemplate jtp;
	
	@Autowired
	private NamedParameterJdbcTemplate njtp;
	
	// saving section
	public void saveByDataSource(student s)
	{
		try( // connection established
				Connection con = ds.getConnection(); 
				//prepared statement
				PreparedStatement ps = con.prepareStatement("insert into giri.student values (?,?,?,?)");
			)
		{// setting parameters to labels
			ps.setInt(1, s.getSid());
			ps.setString(2, s.getSname());
			ps.setInt(3, s.getSage());
			ps.setString(4, s.getScourse());
			int row = ps.executeUpdate();
			System.out.println("Number of rows saved -- "+ row);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveByJdbcTemplate(student s)
	{
		int row = jtp.update("insert into giri.student values (?,?,?,?)", s.getSid(), s.getSname(), s.getSage(), s.getScourse());
		System.out.println("Number of rows saved -- "+ row);
	}
	
	public void saveByNamedParameterJdbcTemplateById(student s)
	{
		MapSqlParameterSource pmap = new MapSqlParameterSource();
		// Setting name tags to getters of student object
		pmap.addValue("sid", s.getSid());
		pmap.addValue("sname", s.getSname());
		pmap.addValue("sage", s.getSage());
		pmap.addValue("scourse", s.getScourse());
		
		
		int row = njtp.update("insert into giri.student values (:sid,:sname,:sage,:scourse)", pmap);
		System.out.println("Number of rows saved -- "+ row);
	}
	
	public void saveByNamedParameterJdbcTemplateByIdOne(student s)
	{
		SqlParameterSource pmap = new BeanPropertySqlParameterSource(s);
		
		// ********* Important : --- names of instance variables and name tags should match each other 
		
		int row = njtp.update("insert into giri.student values (:sid,:sname,:sage,:scourse)", pmap);
		System.out.println("Number of rows saved -- "+ row);
	}
	
	
	// -------------- Reading data from a file system with path -----------------------
	public List<student> getData_FromFile(String path)
	{	
		List<student> data = new ArrayList<>();
		
		try(FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr))
		{
			for(String s = br.readLine(); s != null; s = br.readLine())
			{
				student b = new student();
				String[] d = s.split(",");
				b.setSid(Integer.parseInt(d[0]));
				b.setSname(d[1]);
				b.setSage(Integer.parseInt(d[2]));
				b.setScourse(d[3]);
				
				data.add(b);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	// -------------------------------------------------------------------------------------------------------
	
	// Reading the data from file and saving the data into database
	public void saveByDataSourceFromFile(String path)
	{
		List<student> data = getData_FromFile(path);
		try(
				Connection connection = ds.getConnection(); 
				PreparedStatement ps = connection.prepareStatement("insert into giri.student values (?,?,?,?)")
			)
		{
			connection.setAutoCommit(false); // setting auto commit mode false So that java doesnot save data without our explicit commit method call of connection object
			
			for(student s : data)
			{	
				// setting values to the labels  
				ps.setInt(1, s.getSid());
				ps.setString(2, s.getSname());
				ps.setInt(3, s.getSage());
				ps.setString(4, s.getScourse());
				
				ps.addBatch();// Adding command to a batch of commands
			}// Now all the student entries are ready to insert, each student details corressponds to one insert query, with its respective parameters.
			try {
			    int[] countArr = ps.executeBatch();
			    // executing the batch of commands to the data base, if successfully entered, we have to commit, otherwise  we need to roll back the transaction
			    connection.commit(); // If this method is called then our commands will make permanent changes in the database according to transaction concept
			    System.out.println("Data committed to the database Successfully......");
			    System.out.println("No of rows saved is "+ countArr.length);
			} 
			catch(Exception e)
			{	
				System.out.println("Exception occured, So data  will be roll backed.");
				connection.rollback();
				e.printStackTrace();
			}
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void saveByJdbcTemplateFromFile(String path)
	{
		List<student> data = getData_FromFile(path);
		// we got student objects reading the data from the file
		
		List<Object[]> arr = new ArrayList<>();
		// now we will add each student attributes to object arrays
		
		for(student s : data)
		{
			Object[] v = {s.getSid(), s.getSname(), s.getSage(), s.getScourse()};
			arr.add(v);// Object arrays are added to list
		}
		// using jdbc template overloaded batchUpdate method
		int[] updates = jtp.batchUpdate("insert into giri.student values (?,?,?,?)", arr);
		System.out.println("Number of rows affected -- "+ updates);
		
	}
	
	public void saveByNamedParameterJdbcTemplateFromFile(String path)
	{
		List<student> data = getData_FromFile(path);
		// we got student objects reading the data from the file
		
		
		MapSqlParameterSource[] pmap1 = new MapSqlParameterSource[data.size()];
		// array of MapSqlParameterSource objects
		
		//using loop to map name tags of query to each student attributes
		// Two ways to map named tag parameters and values
		// way ------- 1
		for(int i=0; i<data.size(); i++)
		{	
			student s = data.get(i);
			MapSqlParameterSource b = new MapSqlParameterSource();
			b.addValue("sid", s.getSid());
			b.addValue("sname", s.getSname());
			b.addValue("sage", s.getSage());
			b.addValue("scourse", s.getScourse());
			// Add that MapSqlParameterSource object to array
			pmap1[i] = b;
			
		}
		
		// way ------- 2
		BeanPropertySqlParameterSource[] pmap2 = new BeanPropertySqlParameterSource[data.size()];
		for(int i=0; i<data.size(); i++)
		{
			student s = data.get(i);
			BeanPropertySqlParameterSource v = new BeanPropertySqlParameterSource(s);
			//Note : Here the named tags of the query and attribute names in the object should be same
			pmap2[i] = v;
		}
		
		// Using batch update method of named parmater jdbc template
		int[] updates = njtp.batchUpdate("insert into giri.student values (:sid,:sname,:sage,:scourse)", pmap1);
		System.out.println("Number of rows affected -- "+ updates.length);
	}
	
	
	
	public void UpdateNameByDataSourceById(int sid, String sname)
	{	
		String q = "update giri.student set sname = ? where sid = ?";
		try(
				Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(q);
			)
		{	
			ps.setString(1, sname);
			ps.setInt(2, sid);
			
			int rows = ps.executeUpdate();
			System.out.println("Number of rows updated -- "+ rows);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void UpdateNameByJdbcTemplateById(int sid, String sname)
	{
		int rows = jtp.update("update giri.student set sname = ? where sid = ?", sname, sid);
		System.out.println("Number of rows updated -- "+ rows);
	}
	
	public void UpdateNameByNamedParameterJdbcTemplateById(int sid, String sname)
	{	
		MapSqlParameterSource m = new MapSqlParameterSource();
		m.addValue("sname", sname);
		m.addValue("sid", sid);
		int rows = njtp.update("update giri.student set sname = :sname where sid = :sid", m);
		System.out.println("Number of rows updated -- "+ rows);
	}
	
	
	
	public void UpdateAgeByDataSourceById(int sid, int sage)
	{
		String q = "update giri.student set sage = ? where sid = ?";
		try(
				Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(q);
			)
		{	
			ps.setInt(1, sage);
			ps.setInt(2, sid);
			
			int rows = ps.executeUpdate();
			System.out.println("Number of rows updated -- "+ rows);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void UpdateAgeByJdbcTemplateById(int sid, int sage)
	{
		int rows = jtp.update("update giri.student set sage = ? where sid = ?", sage, sid);
		System.out.println("Number of rows updated -- "+ rows);
	}
	
	public void UpdateAgeByNamedParameterJdbcTemplateById(int sid, int sage)
	{	
		MapSqlParameterSource p = new MapSqlParameterSource();
		p.addValue("sage", sage);
		p.addValue("sid", sid);
		
		int rows = njtp.update("update giri.student set sage = :sage where sid = :sid", p);
		System.out.println("Number of rows updated -- "+ rows);
	}
	
	
	
	public void UpdateCourseByDataSourceById(int sid, String scourse)
	{
		String q = "update giri.student set scourse = ? where sid = ?";
		try(
				Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(q);
			)
		{	
			ps.setString(1, scourse);
			ps.setInt(2, sid);
			
			int rows = ps.executeUpdate();
			System.out.println("Number of rows updated -- "+ rows);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void UpdateCourseByJdbcTemplateById(int sid, String scourse)
	{
		int rows = jtp.update("update giri.student set scourse = ? where sid = ?",scourse, sid);
		System.out.println("Number of rows updated -- "+ rows);
	}
	
	public void UpdateCourseByNamedParameterJdbcTemplateById(int sid, String scourse)
	{
		MapSqlParameterSource p = new MapSqlParameterSource();
		p.addValue("scourse", scourse);
		p.addValue("sid", sid);
		
		int rows = njtp.update("update giri.student set scourse = :scourse where sid = :sid", p);
		System.out.println("Number of rows updated -- "+ rows);
	}
	
}
