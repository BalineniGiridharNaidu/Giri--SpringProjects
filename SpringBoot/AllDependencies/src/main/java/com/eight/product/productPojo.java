package com.eight.product;

public class productPojo
{
	private int pid;
	private String pname;
	private double pprice;
	private double pgst;
	
	
	
	
	public productPojo()
	{
		
	}

	public productPojo(int pid, String pname, double pprice, double pgst)
	{
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pgst = pgst;
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

	@Override
	public String toString()
	{
		return "productPojo [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pgst=" + pgst + "]";
	}
	
	
}
