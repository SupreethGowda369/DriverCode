package com.webapp.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ReadCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookie = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		
		out.println("Name1  : "+cookie[0].getName());
		out.println("Value1 : "+cookie[0].getValue());
		
		out.println("Name2  : "+cookie[1].getName());
		out.println("Value2 : "+cookie[1].getValue());
	}
}
