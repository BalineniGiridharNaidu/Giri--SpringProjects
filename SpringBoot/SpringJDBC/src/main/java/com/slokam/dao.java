package com.slokam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class dao
{	
	//@Autowired
	private  DataSource ds;
	
	@Autowired
	private JdbcTemplate jdbctemp;
	
	
	public void saveByJdbcTemplate(empPojo e)
	{
		System.out.println("Dao saveByJdbcTemplate saving started");
		System.out.println(jdbctemp);
		System.out.println("Dao saveByJdbcTemplate saving completed");
	}
	
	
	public void updateById(int eid)
	{	
		String query = "update spring_jdbc.employee set ename = 'siva kumar' where eid = ?";
		try( Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(query); )
		{
			ps.setInt(1, eid);
			int rows = ps.executeUpdate();
			System.out.println("No of rows affected is "+ rows );
		}
		catch(Exception e)
		{
			System.out.println("updateById catch block executed");
			e.printStackTrace();
		}
	}
	
	
	public void AddListOfEmpFromReadingTextFileWithBATCH_COMMAND(String path)
	{	
		ArrayList<empPojo> data = new ArrayList<>();
		String query = "insert into spring_jdbc.employee values (?,?,?,?);";
		
		try(	//connecting java and filesystem
				FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);
				
				// connecting java and database
				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
		   )
		{
			//read data from file and save employee objects into an arraylist
			String s = br.readLine();
			while(s!=null)
			{
				String[] ed = s.split(","); // splitting the line
				empPojo e = new empPojo();
				e.setEid(Integer.parseInt(ed[0]));
				e.setEname(ed[1]);
				e.setEage(Integer.parseInt(ed[2]));
				e.setEsal(Double.parseDouble(ed[3]));
				data.add(e);
				 
				s = br.readLine(); // updation of line by moving cursor to the next line 
			}
			
//			 now use that arraylist and save data into database
			con.setAutoCommit(false);
			try {
					for(empPojo e : data)
					{
						ps.setInt(1, e.getEid());
						ps.setString(2, e.getEname());
						ps.setInt(3, e.getEage());
						ps.setDouble(4, e.getEsal());
						ps.addBatch();
					}
					System.out.println("Just before the batch");
					int[]  result = ps.executeBatch();
					System.out.println("Just after the batch");
					
					con.commit();
					for(int i=0; i<result.length; i++)
					{
						System.out.println("statement "+ (i+1) + ": number of rows affected is "+ result[i] );
					}
			}catch (Exception e) {
					con.rollback();
					System.out.println("Roll backed the transaction successfully");
			}
			
			
			System.out.println("Data saved successfully");
		}
		catch(Exception e)
		{
			System.out.println("AddEmpFromReadingTextFile CATCH block executed");
			e.printStackTrace();
		}
		
	}
	
	public void AddListOfEmpFromReadingTextFile(String path)
	{	
		ArrayList<empPojo> data = new ArrayList<>();
		String query = "insert into spring_jdbc.employee values (?,?,?,?);";
		
		try(	//connecting java and filesystem
				FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);
				
				// connecting java and database
				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
		   )
		{
			//read data from file and save employee objects into an arraylist
			String s = br.readLine();
			while(s!=null)
			{
				String[] ed = s.split(","); // splitting the line
				empPojo e = new empPojo();
				e.setEid(Integer.parseInt(ed[0]));
				e.setEname(ed[1]);
				e.setEage(Integer.parseInt(ed[2]));
				e.setEsal(Double.parseDouble(ed[3]));
				data.add(e);
				 
				s = br.readLine(); // updation of line by moving cursor to the next line 
			}
			
			// now use that arraylist and save data into database
//			for(empPojo e : data)
//			{
//				ps.setInt(1, e.getEid());
//				ps.setString(2, e.getEname());
//				ps.setInt(3, e.getEage());
//				ps.setDouble(4, e.getEsal());
//				ps.executeUpdate();
//			}
			
			for(empPojo e : data)
			{
				ps.setInt(1, e.getEid());
				ps.setString(2, e.getEname());
				ps.setInt(3, e.getEage());
				ps.setDouble(4, e.getEsal());
				// this try and catch block is used to  exempt the entry of duplicate ids
				// if a duplicate entry occurs, then it throws an exception for that single entry
				// so that execution flow won't be disturbed
				//other entries after the duplicate entry will be saved without error
				try { ps.executeUpdate(); } catch(Exception ex) { System.out.println("duplicate entry for "+ e.getEid());}
				
			}
			
			System.out.println("Data saved successfully");
		}
		catch(Exception e)
		{
			System.out.println("AddEmpFromReadingTextFile CATCH block executed");
			e.printStackTrace();
		}
		
	}
	
	public void getMinSalEmp()
	{	
		String query = " select * from spring_jdbc.employee where esal = (select min(esal) from spring_jdbc.employee);";
		try( Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(query); )
		{
			ResultSet rs = ps.executeQuery();
			boolean isHaving = rs.next();
			if(!isHaving)
				System.out.println("Sorry no such person in the database");
			while(isHaving) 
			{
				empPojo e = new empPojo();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEage(rs.getInt(3));
				e.setEsal(rs.getDouble(4));
				System.out.println(e);
				
				isHaving = rs.next();
			}
		}
		catch(Exception e)
		{
			System.out.println("getMinSalEmp catch block executed");
			e.printStackTrace();
		}
	}
	
	public void getMaxSalEmp()
	{	
		String query = " select * from spring_jdbc.employee where esal = (select max(esal) from spring_jdbc.employee);";
		try( Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(query); )
		{
			ResultSet rs = ps.executeQuery();
			boolean isHaving = rs.next();
			if(!isHaving)
				System.out.println("Sorry no such person in the database");
			while(isHaving) 
			{
				empPojo e = new empPojo();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEage(rs.getInt(3));
				e.setEsal(rs.getDouble(4));
				System.out.println(e);
				
				isHaving = rs.next();
			}
		}
		catch(Exception e)
		{
			System.out.println("getMaxSalEmp catch block executed");
			e.printStackTrace();
		}
	}
	
	
	public void getAllDESC()
	{
		System.out.println("getAllDESC ops started in datasource");
		String query = " select * from spring_jdbc.employee order by ename desc ";
		try( Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(query);)
		{
			ResultSet rs = ps.executeQuery();
			boolean isNotNull = rs.next();
			if(!isNotNull)
				System.out.println("No persons in the data base");
			while(isNotNull)
			{	
				empPojo e = new empPojo();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEage(rs.getInt(3));
				e.setEsal(rs.getDouble(4));
				System.out.println(e);
				isNotNull = rs.next();
			}
			
		}
		catch(Exception e)
		{
			System.out.println("getAllDESC method catch block executed ");
		}
		System.out.println("getAllDESC ops ended in datasource");
	}
	
	public void getAllASC()
	{
		System.out.println("getAllASC ops started in datasource");
		String query = " select * from spring_jdbc.employee order by ename asc ";
		try( Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(query);)
		{
			ResultSet rs = ps.executeQuery();
			boolean isNotNull = rs.next();
			if(!isNotNull)
				System.out.println("No persons in the data base");
			while(isNotNull)
			{	
				empPojo e = new empPojo();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEage(rs.getInt(3));
				e.setEsal(rs.getDouble(4));
				System.out.println(e);
				isNotNull = rs.next();
			}
			
		}
		catch(Exception e)
		{
			System.out.println("getAllASC method catch block executed ");
		}
		System.out.println("getAllASC ops ended in datasource");
	}
	
	
	public void getAll()
	{
		System.out.println("Get all ops started in datasource");
		String query = " select * from spring_jdbc.employee";
		try( Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(query);)
		{
			ResultSet rs = ps.executeQuery();
			boolean isNotNull = rs.next();
			if(!isNotNull)
				System.out.println("No persons in the data base");
			while(isNotNull)
			{	
				empPojo e = new empPojo();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEage(rs.getInt(3));
				e.setEsal(rs.getDouble(4));
				System.out.println(e);
				isNotNull = rs.next();
			}
			
		}
		catch(Exception e)
		{
			System.out.println("getAll method catch block executed ");
		}
		System.out.println("Get all ops ended in datasource");
	}
	
	public void searchByLastLetter(String a )
	{	
		String q = "select * from spring_jdbc.employee where ename like ?";
		try(Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(q); )
		{
			ps.setString(1,  ("%"+a) );
			boolean isResultSet = ps.execute();
			if(isResultSet) 
			{	
				System.out.println("Output will be result set");
				ResultSet rs = ps.getResultSet();
				boolean isNotNull = rs.next();
				if(!isNotNull)
					System.out.println("No such person name is started with the letter ----- "+ a);
				while(isNotNull)
				{
					empPojo e = new empPojo();
					e.setEid(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setEage(rs.getInt(3));
					e.setEsal(rs.getDouble(4));
					System.out.println(e);
					isNotNull = rs.next();
				}
				System.out.println(rs);
			}
			else
			{
				System.out.println("Output wont be result set");
				System.out.println("Update count is "+ ps.getUpdateCount());
			}
		}catch(Exception e)
		{
			System.out.println("searchByLastLetter catch block executed");
			e.printStackTrace();
		}
	}
	
	
	
	public void searchByFirstLetter(String a )
	{	
		String q = "select * from spring_jdbc.employee where ename like ?";
		try(Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(q); )
		{
			ps.setString(1,  (a+"%") );
			boolean isResultSet = ps.execute();
			if(isResultSet) 
			{	
				System.out.println("Output will be result set");
				ResultSet rs = ps.getResultSet();
				boolean isNotNull = rs.next();
				while(isNotNull)
				{
					empPojo e = new empPojo();
					e.setEid(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setEage(rs.getInt(3));
					e.setEsal(rs.getDouble(4));
					System.out.println(e);
					isNotNull = rs.next();
				}
				if(!isNotNull)
				System.out.println("No such person name is started with the letter ----- "+ a);
				System.out.println(rs);
			}
			else
			{
				System.out.println("Output wont be result set");
				System.out.println("Update count is "+ ps.getUpdateCount());
			}
		}catch(Exception e)
		{
			System.out.println("searchByFirstLetter catch block executed");
			e.printStackTrace();
		}
	}
	
	public void searchByName(String ename)
	{
		System.out.println("dao name search started");
		try
		{	
			//getting connection from basicDataSource Object
			Connection con = ds.getConnection();
			String q = "select * from spring_jdbc.employee where ename like ?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, "%"+ename+"%");
			boolean isResultSet = ps.execute();
			if(isResultSet)
			{
				System.out.println("Output is a result set");
				ResultSet rs = ps.getResultSet();
				while(rs.next())
				{	
					empPojo e = new empPojo();
					e.setEid(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setEage(rs.getInt(3));
					e.setEsal(rs.getDouble(4));
					System.out.println(e);
				}
			}
		} catch (SQLException e)
		{
			System.out.println("searchByName(String ename) dao catch block executed");
			e.printStackTrace();
		}
		
		System.out.println("dao name search completed");
	}
	
	
	public void save(empPojo e)
	{
		System.out.println("dao saving started");
		String q = "insert into spring_jdbc.employee values (?,?,?,?);";
		try( Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(q); )
		{
			ps.setInt(1, e.getEid());
			ps.setString(2, e.getEname());
			ps.setInt(3, e.getEage());
			ps.setDouble(4, e.getEsal());
			
			int rows = ps.executeUpdate();
			System.out.println("rows affected is "+ rows);
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		System.out.println("dao saving completed");
	}
	
	public void getById(int eid)
	{
		//database get code
		String q = "select * from spring_jdbc.employee where eid = ?";
		try(Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(q);)
		{
			ps.setInt(1, eid);
			boolean isResultSet = ps.execute();
			if(isResultSet)
			{
				System.out.println("Output will be resultset");
				ResultSet rs = ps.getResultSet();
				while(rs.next())
				{	
					empPojo ei = new empPojo();
					ei.setEid(rs.getInt(1));
					ei.setEname(rs.getString(2));
					ei.setEage(rs.getInt(3));
					ei.setEsal(rs.getDouble(4));
					System.out.println(ei);
				}
			}
			else
			{
				System.out.println("No of rows affected is "+ ps.getUpdateCount());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
