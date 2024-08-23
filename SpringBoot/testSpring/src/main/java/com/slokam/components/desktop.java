package com.slokam.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class desktop
{	
	@Autowired
	private monitor mon;
	
	@Autowired
	private cpu cp;
	
	@Autowired
	private keyboard kb;
	
	@Autowired
	private mouse mous;
	
	public void start()
	{
		System.out.println("Desktop booting process started.........\n-----------------------------------------");
		cp.start();
		mon.start();
		kb.start();
		mous.start();
		System.out.println("Desktop booting process completed.........\n-----------------------------------------");
	}
}
