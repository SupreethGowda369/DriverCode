package com.jspiders.jdbc.add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class AddMultipleColumn {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try 
		{
			Driver driverrf = new Driver();
			DriverManager.registerDriver(driverrf);
			
			String dburl = "jdbc:mysql://localhost:3306/multicolumn?user=root&password=data";
			con = DriverManager.getConnection(dburl);
			
			String query1 = " INSERT INTO t1 "
					      + " VALUES(?,?) ";
			String query2 = " INSERT INTO t2 "
				          + " VALUES(?,?) ";
			String query3 = " INSERT INTO t3 "
				          + " VALUES(?,?) ";
			
			pstmt1 = con.prepareStatement(query1);
			pstmt1.setInt(1, Integer.parseInt(args[0]));
			pstmt1.setString(2, args[1]);
			
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setInt(1, Integer.parseInt(args[2]));
			pstmt2.setString(2, args[3]);
			
			pstmt3 = con.prepareStatement(query3);
			pstmt3.setInt(1, Integer.parseInt(args[4]));
			pstmt3.setString(2, args[5]);
			
			int res1 = pstmt1.executeUpdate();
			int res2 = pstmt2.executeUpdate();
			int res3 = pstmt3.executeUpdate();
			
			if(res1!=0 && res2!=0 && res3!=0)
			{
				System.out.println("Record has inserted.....");
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
				if(pstmt1!=null)
				{
					pstmt1.close();
				}
				if(pstmt2!=null)
				{
					pstmt2.close();
				}
				if(pstmt3!=null)
				{
					pstmt3.close();
				}
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
}
