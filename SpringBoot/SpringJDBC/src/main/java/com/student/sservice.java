package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class sservice
{	
	@Autowired
	private sDao da;
	
	
	public void saveByDataSource(student s)
	{
		da.saveByDataSource(s);
	}
	
	public void saveByJdbcTemplate(student s)
	{
		da.saveByJdbcTemplate(s);
	}
	
	public void saveByNamedParameterJdbcTemplateById(student s)
	{
		da.saveByNamedParameterJdbcTemplateById(s);
	}
	
	
	
	public void saveByDataSourceFromFile(String path)
	{
		da.saveByDataSourceFromFile(path);
	}
	
	public void saveByJdbcTemplateFromFile(String path)
	{
		da.saveByJdbcTemplateFromFile(path);
	}
	
	public void saveByNamedParameterJdbcTemplateFromFile(String path)
	{
		da.saveByNamedParameterJdbcTemplateFromFile(path);
	}
	
	
	
	public void UpdateNameByDataSourceById(int sid, String sname)
	{
		da.UpdateNameByDataSourceById(sid, sname);
	}
	
	public void UpdateNameByJdbcTemplateById(int sid, String sname)
	{
		da.UpdateNameByJdbcTemplateById(sid, sname);
	}
	
	public void UpdateNameByNamedParameterJdbcTemplateById(int sid, String sname)
	{
		da.UpdateNameByNamedParameterJdbcTemplateById(sid, sname);
	}
	
	
	
	public void UpdateAgeByDataSourceById(int sid, int sage)
	{
		da.UpdateAgeByDataSourceById(sid, sage);
	}
	
	public void UpdateAgeByJdbcTemplateById(int sid, int sage)
	{
		da.UpdateAgeByJdbcTemplateById(sid, sage);
	}
	
	public void UpdateAgeByNamedParameterJdbcTemplateById(int sid, int sage)
	{
		da.UpdateAgeByNamedParameterJdbcTemplateById(sid,sage);
	}
	
	
	
	public void UpdateCourseByDataSourceById(int sid, String scourse)
	{
		da.UpdateCourseByDataSourceById(sid, scourse);
	}
	
	public void UpdateCourseByJdbcTemplateById(int sid, String scourse)
	{
		da.UpdateCourseByJdbcTemplateById(sid, scourse);
	}
	
	public void UpdateCourseByNamedParameterJdbcTemplateById(int sid, String scourse)
	{
		da.UpdateCourseByNamedParameterJdbcTemplateById(sid, scourse);
	}
}
