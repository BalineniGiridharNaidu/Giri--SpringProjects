package com.slokam.test;

import java.lang.reflect.*;

class person
{
	private int pid;
	private String pname;
	private int page;
}

public class test
{

	public static void main(String[] args)
	{
		Class<person> r = person.class;
		System.out.println(r);
		
		
	}

}
