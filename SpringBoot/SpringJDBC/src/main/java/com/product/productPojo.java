package com.product;

public class productPojo
{
	private int pid;
	private String pname;
	private double pprice;
	private double pgst;
	private String ptype;
	
	
	
	public productPojo()
	{
		super();
	}



	public productPojo(int pid, String pname, double pprice, double pgst, String ptype)
	{
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pgst = pgst;
		this.ptype = ptype;
	}



	public int getPid()
	{
		return pid;
	}



	public void setPid(int pid)
	{
		this.pid = pid;
	}



	public String getPname()
	{
		return pname;
	}



	public void setPname(String pname)
	{
		this.pname = pname;
	}



	public double getPprice()
	{
		return pprice;
	}



	public void setPprice(double pprice)
	{
		this.pprice = pprice;
	}



	public double getPgst()
	{
		return pgst;
	}



	public void setPgst(double pgst)
	{
		this.pgst = pgst;
	}



	public String getPtype()
	{
		return ptype;
	}



	public void setPtype(String ptype)
	{
		this.ptype = ptype;
	}



	@Override
	public String toString()
	{
		return pid+" -- "+pname+" -- "+pprice+" -- "+pgst+" -- "+ptype;
	}
	
	
	
	
}
