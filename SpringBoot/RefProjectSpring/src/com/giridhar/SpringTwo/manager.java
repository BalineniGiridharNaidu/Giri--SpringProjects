package com.giridhar.SpringTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class manager
{	
	@Autowired
    private teamlead tl;
	
	
	
	public void setTl(teamlead tl)
	{
		this.tl = tl;
	}



	public void doWork()
	{
		System.out.println("Manager work started");
		tl.doWork();
		System.out.println("Manager work completed");
	}
}
