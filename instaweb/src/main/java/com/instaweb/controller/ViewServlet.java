package com.instaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instaweb.dao.InstaDAOInterface;
import com.instaweb.entity.InstaUser;
import com.instaweb.utilty.FactoryDAO;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String password=request.getParameter("pw");
		//String email=request.getParameter("em");
		//HttpSession ss=request.getSession(true);
		ServletContext ss=getServletContext();
		Object oo=ss.getAttribute("id");
		InstaUser us=new InstaUser();
		//us.setPassword(password);
		//us.setEmail(email);
		us.setEmail(oo.toString());
		InstaDAOInterface dd=FactoryDAO.createObjectHibernet();
		InstaUser iu=dd.ViewProfile(us);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><style>body{background-color:#e6f9ff;}</style><center><br><br>");
		out.println("<font size=5><b><p><i>*** Your Profile :) ***</font></b></i></p>");
		if(iu!=null) {
			out.println("<table>");
			out.println("<tr><td><font color=blue>Name :</font>"+iu.getName()+"</td></tr>");
			out.println("<tr><td><font color=blue>UserName :</font>"+iu.getUsername()+"</td></tr>");
			out.println("<tr><td><font color=blue>DOB :</font>"+iu.getDob()+"</td></tr>");
			out.println("<tr><td><font color=blue>Location :</font>"+iu.getAddress()+"</td></tr>");
			out.println("</table>");
			out.println("<br>");
			out.println("<font>Go back to <a href=LoginSuccess>home</a></font>");
		}else {
			out.println("<font size=5 color=red><b>Profile Not Found</b></font>");
		}
		out.println("</center></body></html>");
	}

}
