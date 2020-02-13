package com.jspiders.company.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver

public class RetrieveHelperClass 
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
			
			String dburl = "jdbc:mysql://localhost:3306/company?user=root&password=data";
				     con = DriverManager.getConnection(dburl);
			String query = " SELECT * FROM employee ";
				    stmt = con.createStatement();
				      rs = stmt.executeQuery(query);
				      
		    while(rs.next())
			{
		    	int empid = rs.getInt("id");
		    	String eName = rs.getString("name");
		    	String eAddress = rs.getString("address");
					    	
			  	System.out.println("Employee ID      :"+empid);
			  	System.out.println("Employee Name    :"+eName);
		    	System.out.println("Employee Address :"+eAddress);
		    	
		    	System.out.println("----------------------------");	
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
