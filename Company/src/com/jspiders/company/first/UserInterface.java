package com.jspiders.company.first;

public class UserInterface 
{
	public static void main(String[] args) 
	{
		Employee e1 = new Employee(100,"Supreeth","Kunigal");
		Employee e2 = new Employee(200,"Shashi","Nanjanagudu");
		
		InsertHelperClass.insert(e1);
		InsertHelperClass.insert(e2);	
	}
}