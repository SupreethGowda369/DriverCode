package com.webapp.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DateServlet extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		Date date = new Date();
		out.println("Current Date and Time : " + date);	
		
		String url3 = "https://www.google.com/";
		resp.sendRedirect(url3);
		String url4 = "date";
		resp.sendRedirect(url4);
		
		String url1 = "date";
		RequestDispatcher dispatcher1 = req.getRequestDispatcher(url1);
		dispatcher1.forward(req, resp);
		
		out.println("11111111111111111111111111111111111");
		String url2 = "date";
		RequestDispatcher dispatcher2 = req.getRequestDispatcher(url2);
		dispatcher2.include(req, resp);
		out.println("22222222222222222222222222222222222");
	}
}
