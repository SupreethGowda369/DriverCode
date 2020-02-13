package com.jspiders.company.first;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class DeleteHelperClass 
{
	public static void main(String[] args) throws IOException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		File file = new File("C://J2ee//MyFolder/company.properties");
		FileReader reader = new FileReader(file);
		Properties prop = new Properties();
		prop.load(reader);
		
		try 
		{
			Driver driverref = new Driver();
			DriverManager.deregisterDriver(driverref);
			String url = prop.getProperty("dburl");
			con = DriverManager.getConnection(url, "root", "data");
			String query = " delete from employee "
	    		         + " where id = ? ";
		    pstmt = con.prepareStatement(query); 
		    pstmt.setInt(1, Integer.parseInt(args[0]));
		    int res = pstmt.executeUpdate();
		    if(res!=0)
		    {
		    	System.out.println("Record has been deleted.......Ss");
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
