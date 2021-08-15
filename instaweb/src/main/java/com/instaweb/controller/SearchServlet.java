package com.instaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instaweb.dao.InstaDAOInterface;
import com.instaweb.entity.InstaUser;
import com.instaweb.utilty.FactoryDAO;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		InstaUser us=new InstaUser();
		us.setUsername(username);
		//System.out.println(iu.getEmail());
		InstaDAOInterface ob=FactoryDAO.createObjectHibernet();
		InstaUser ww=ob.SearchProfile(us);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><style>body{background-color:#e6f9ff;}</style><center><br><br>");
		if(ww!=null) {
			out.println("<table>");
			out.println("<tr><td><font color=blue>Name :</font>"+ww.getName()+"</td></tr>");
			out.println("<tr><td><font color=blue>UserName :</font>"+ww.getUsername()+"</td></tr>");
			out.println("<tr><td><font color=blue>DOB :</font>"+ww.getDob()+"</td></tr>");
			out.println("<tr><td><font color=blue>Location :</font>"+ww.getAddress()+"</td></tr>");
			out.println("</table>");
			out.println("<br>");
			out.println("<font>Go back to <a href=LoginSuccess>home</a></font>");
		}else {
			out.println("<font size=5 color=red><b>Profile Not Found</b></font>");
		}
		out.println("</center></body></html>");
	}

}
