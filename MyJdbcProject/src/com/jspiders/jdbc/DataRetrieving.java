package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataRetrieving 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/student_information?user=root&password=data";
				     con = DriverManager.getConnection(dburl);
			String query = "SELECT * FROM STUDENT_INFO";
				    stmt = con.createStatement();
				      rs = stmt.executeQuery(query);
		    while(rs.next())
			{
		    	int RegNum = rs.getInt("REG_NO");
		    	String fName = rs.getString("FIRST_NAME");
		    	String mName = rs.getString("MIDDLE_NAME");
			  	String lName = rs.getString("LAST_NAME");
					    	
			  	System.out.println("Register Num :" + RegNum);
			  	System.out.println("First Name   :" + fName);
		    	System.out.println("Middle Name  :" + mName);
		    	System.out.println("Last Name    :" + lName);
		    	System.out.println("--------------------------------");	
			}		      
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
