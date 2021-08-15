package com.instaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instaweb.dao.InstaDAOInterface;
import com.instaweb.entity.InstaUser;
import com.instaweb.utilty.FactoryDAO;
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String username=request.getParameter("uname");
		String email=request.getParameter("em");
		String password=request.getParameter("pw");
		InstaUser us=new InstaUser();
		us.setEmail(email);
		us.setPassword(password);
		//InstaDAOInterface dd=FactoryDAO.createObject();
		InstaDAOInterface dd1=FactoryDAO.createObjectHibernet();
		InstaUser b=dd1.LoginProfile(us);
		//HttpSession ss=request.getSession(true);
		ServletContext sc=getServletContext();
		//sc.setAttribute("uname", username);
		sc.setAttribute("id", email);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><center><br><br>");
		if(b!=null) {
			sc.setAttribute("name", b.getName());
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/LoginSuccess");
			rd.forward(request, response);
		}else {
			out.println("<font size=5 color=red><b>Invalid Username or Password :)</b></font>");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		out.println("</center></body></html>");
	}

}
