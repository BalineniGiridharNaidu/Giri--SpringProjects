package com.student;

public class student
{
	private int sid;
	private String sname;
	private int sage;
	private String scourse;
	
	public student(int sid, String sname, int sage, String scourse)
	{
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.scourse = scourse;
	}

	public student()
	{
		super();
	}

	public int getSid()
	{
		return sid;
	}

	public void setSid(int sid)
	{
		this.sid = sid;
	}

	public String getSname()
	{
		return sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}

	public int getSage()
	{
		return sage;
	}

	public void setSage(int sage)
	{
		this.sage = sage;
	}

	public String getScourse()
	{
		return scourse;
	}

	public void setScourse(String scourse)
	{
		this.scourse = scourse;
	}

	@Override
	public String toString()
	{
		return "student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", scourse=" + scourse + "]";
	}
	
}
