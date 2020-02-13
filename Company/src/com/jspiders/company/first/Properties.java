package com.jspiders.company.first;

import java.io.File;
import java.io.IOException;

public class Properties 
{
	public static void main(String[] args) throws IOException 
	{
		File file = new File("C://J2ee//MyFolder/company.properties");
		boolean bool = file.createNewFile();
		System.out.println(bool);
	}
}
