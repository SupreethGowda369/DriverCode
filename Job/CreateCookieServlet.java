package com.webapp.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CreateCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie ck1 = new Cookie("MyName", "Supreeth");
		ck1.setMaxAge(7*24*60*60);
		resp.addCookie(ck1);
		
		Cookie ck2 = new Cookie("MyLocation", "Kunigal");
		ck2.setMaxAge(7*24*60*60);
		resp.addCookie(ck2);
		
		PrintWriter out = resp.getWriter();
		out.println("Cookie is created.......");
	}
}
