package com.jspiders.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class DataDeleting 
{
	public static void main(String[] args) throws IOException 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		File file = new File("C://J2ee//MyFolder/database.properties");
		FileReader reader = new FileReader(file);
		Properties prop = new Properties();
		prop.load(reader);
		
		try 
		{
			Driver driverref = new Driver();
			DriverManager.deregisterDriver(driverref);
			String url = prop.getProperty("dburl");
			con = DriverManager.getConnection(url, "root", "data");
			String query = " DELETE FROM STUDENT_INFO "
	    		         + " WHERE REG_NO = ? ";
		    pstmt = con.prepareStatement(query); 
		    pstmt.setInt(1, Integer.parseInt(args[0]));
		    int res = pstmt.executeUpdate();
		    if(res!=0)
		    {
		    	System.out.println("Record has been successfully deleted");
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
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
