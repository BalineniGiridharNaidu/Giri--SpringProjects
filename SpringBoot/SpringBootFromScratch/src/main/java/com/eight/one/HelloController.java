package com.eight.one;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{	
	@GetMapping
	public String home()
	{
		return "Welcome Home Giri !!!!!!!!!!!";
	}
	
	@GetMapping("/loans")
	public String Loans()
	{
		return "Welcome to Loans Section";
	}
}
