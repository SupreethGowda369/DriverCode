package com.jspiders.marriage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class UserDetails {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Connection con = null;
		FileInputStream inputstream = null;
		PreparedStatement pstmt = null;
		
		try 
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=data";
			         con = DriverManager.getConnection(dburl);
			String query = " insert into person "
					     + " values(?,?,?) ";
			
			File file = new File("C:\\J2ee\\MyFolder\\header.jpg");
			inputstream = new FileInputStream(file);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, args[0]);
			pstmt.setLong(2, Long.parseLong(args[1]));
			pstmt.setBinaryStream(3, inputstream);
			
			int res = pstmt.executeUpdate();
			
			if(res!=0)
			{
				System.out.println("Profile Updated......");
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
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(inputstream!=null)
				{
					inputstream.close();
				}
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
}
