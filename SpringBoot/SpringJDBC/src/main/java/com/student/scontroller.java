package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class scontroller
{	
	@Autowired
	private sservice ss;
	
	public void saveByDataSource(student s)
	{
		ss.saveByDataSource(s);
	}
	
	public void saveByJdbcTemplate(student s)
	{
		ss.saveByJdbcTemplate(s);
	}
	
	public void saveByNamedParameterJdbcTemplateById(student s)
	{
		ss.saveByNamedParameterJdbcTemplateById(s);
	}
	
	
	
	public void saveByDataSourceFromFile(String path)
	{
		ss.saveByDataSourceFromFile(path);
	}
	
	public void saveByJdbcTemplateFromFile(String path)
	{
		ss.saveByJdbcTemplateFromFile(path);
	}
	
	public void saveByNamedParameterJdbcTemplateFromFile(String path)
	{
		ss.saveByNamedParameterJdbcTemplateFromFile(path);
	}
	
	
	
	public void UpdateNameByDataSourceById(int sid, String sname)
	{
		ss.UpdateNameByDataSourceById(sid, sname);
	}
	
	public void UpdateNameByJdbcTemplateById(int sid, String sname)
	{
		ss.UpdateNameByJdbcTemplateById(sid, sname);
	}
	
	public void UpdateNameByNamedParameterJdbcTemplateById(int sid, String sname)
	{
		ss.UpdateNameByNamedParameterJdbcTemplateById(sid, sname);
	}
	
	
	
	public void UpdateAgeByDataSourceById(int sid, int sage)
	{
		ss.UpdateAgeByDataSourceById(sid, sage);
	}
	
	public void UpdateAgeByJdbcTemplateById(int sid, int sage)
	{
		ss.UpdateAgeByJdbcTemplateById(sid, sage);
	}
	
	public void UpdateAgeByNamedParameterJdbcTemplateById(int sid, int sage)
	{
		ss.UpdateAgeByNamedParameterJdbcTemplateById(sid, sage);
	}
	
	
	
	public void UpdateCourseByDataSourceById(int sid, String scourse)
	{
		ss.UpdateCourseByDataSourceById(sid, scourse);
	}
	
	public void UpdateCourseByJdbcTemplateById(int sid, String scourse)
	{
		ss.UpdateCourseByJdbcTemplateById(sid, scourse);
	}
	
	public void UpdateCourseByNamedParameterJdbcTemplateById(int sid, String scourse)
	{
		ss.UpdateCourseByNamedParameterJdbcTemplateById(sid, scourse);
	}
}
