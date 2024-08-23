package com.giridhar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{	
	@GetMapping
	public String home()
	{
		return "Hello Spring Boot..................";
	}
	
	@GetMapping("/home1")
	public String home1()
	{
		return "Hello home1 ..................";
	}
	
	@GetMapping("/home2")
	public String home2()
	{
		return "Hello home2 ..................";
	}
}
