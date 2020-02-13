package com.jspiders.jdbc.job;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CandidateInfomation {

	public static void main(String[] args) throws IOException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try 
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/job?user=root&password=data";
			con = DriverManager.getConnection(dburl);
			
			String query = " insert into candidate "
					     + " values(?,?,?,?) ";
			
			File file = new File("C:\\wamp64\\instructions_for_use.rtf");
			FileReader reader = new FileReader(file);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, args[0]);
			pstmt.setLong(2, Long.parseLong(args[1]));
			pstmt.setString(3, args[2]);
			pstmt.setCharacterStream(4, reader);
			
			int res = pstmt.executeUpdate();
			if(res!=0)
			{
				System.out.println("Profile has been successfully inserted.........");
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
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
}
