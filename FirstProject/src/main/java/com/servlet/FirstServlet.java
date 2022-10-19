package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.*;
public class FirstServlet implements Servlet{

	ServletConfig conf;

	public void init(ServletConfig conf) {
		this.conf = conf;
		System.out.println("Creating Object.......");
	}
	public void service(ServletRequest req, ServletResponse res)throws IOException, ServletException{
		System.out.println("Servicing");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<h1>hi this is comes from servlet</h1>");
		out.print("<h1>Its "+ new Date(0).toString()+" </h1>");
	}

	public void destroy() {
		System.out.print("Going to Destroy");
	}
	public ServletConfig getServletConfig() {
		return this.conf;
	}
	public String getServletInfo() {
		return null;
	}
}
