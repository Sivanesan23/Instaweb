package com.instaweb.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc=getServletContext();
		Object oo=sc.getAttribute("name");
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<html><body><style>body{background-color:#e6f9ff;}</style><center><br><br>");
		out.println("<h1><b>Welcom :) "+"<font color=green>"+oo+"</h1>"+"</b></font>");
		out.println("<table>");
		out.println("<tr><h4><td>1</td><td><a href=viewprofile.html>View Profile</h4></a></td></tr>");
		out.println("<tr><h4><td>2</td><td><a href=search.html>Search Profile<h4></a> </td></tr>");
		out.println("<tr><h4><td>3</td><td><a href=EditServlet>Edit Profile</h4></a></td></tr>");
		out.println("<tr> <h4><td>4</td><td><a href=delete.html>Delete Profile</h4></a></td></tr>");
		out.println("<tr> <h4><td>5</td><td><a href=login.html>Logout</h4></a></td></tr>");
		out.println("</table>");
		out.println("</center></body></html>");
	}
}
