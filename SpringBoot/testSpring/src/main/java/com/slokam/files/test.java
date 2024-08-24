package com.slokam.files;

import java.io.File;

public class test
{
	public static void main(String[] args)
	{
		String path = "./data.txt";
		File f = new File(path);
		System.out.println(f);
	}
}
