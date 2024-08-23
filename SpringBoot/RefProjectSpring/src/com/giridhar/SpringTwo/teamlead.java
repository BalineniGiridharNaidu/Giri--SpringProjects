package com.giridhar.SpringTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class teamlead
{	
	@Autowired
    private developer dev;
	
	
	
	
	public void setDev(developer dev)
	{
		this.dev = dev;
	}




	public void doWork()
	{
		System.out.println("teamlead work started");
		dev.doWork();
		System.out.println("teamlead work completed");
	}
}
