package com.jspiders.company.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertHelperClass 
{
	public static void insert(Employee e) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try 
		{
			Driver driverref= new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/company?user=root&password=data";
			         con = DriverManager.getConnection(dburl);
			String query = " insert into employee "
					     + " values(?,?,?)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, e.getId());
			pstmt.setString(2, e.getName());
			pstmt.setString(3, e.getAddress());
			
			int res = pstmt.executeUpdate();
			
			if(res != 0)
			{
				System.out.println("Record has been inserted");
			}
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con!= null)
				{
					con.close();
				}
				if(pstmt!= null)
				{
					pstmt.close();
				}
			} 
			catch (SQLException e2) 
			{
				e2.printStackTrace();
			}
		}
	}
}
