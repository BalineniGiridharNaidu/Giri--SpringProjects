package com.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GiriCustomRowMapper implements RowMapper<productPojo>
{

	@Override
	public productPojo mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		productPojo p = new productPojo();
		p.setPid(rs.getInt(1));
		p.setPname(rs.getString(2));
		p.setPprice(rs.getDouble(3));// Mapping the columns to the properties 
		p.setPgst(rs.getDouble(4));  // So that name differences between properties of an object and rows of the table
		p.setPtype(rs.getString(5));// doesnot matter
		
		return p;
	}

}
