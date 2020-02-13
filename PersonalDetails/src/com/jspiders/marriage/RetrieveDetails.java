package com.jspiders.marriage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class RetrieveDetails 
{
	public static void main(String[] args) throws IOException  
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		OutputStream os = null;
		InputStream is = null;
		
		try 
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=data";
			         con = DriverManager.getConnection(dburl);
			String query = " SELECT Photo "
					     + " FROM person ";
			
			        stmt = con.createStatement();
			          rs = stmt.executeQuery(query);
			          
			File file = new File("C://J2ee//MyFolder/image.jpg");
			
			      os = new FileOutputStream(file);
			      
			byte[] a = new byte[1024];
			if(rs.next())
			{
				is = rs.getBinaryStream("Photo");
				while(is.read(a)>0)
				{
					os.write(a);
				}
				System.out.println("Profile extracted........");
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
				if(rs!=null)
				{
					rs.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
				if(is!=null)
				{
					is.close();
				}
				if(os!=null)
				{
					os.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
