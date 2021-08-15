package com.instaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.instaweb.dao.InstaDAOInterface;
import com.instaweb.entity.InstaUser;
import com.instaweb.utilty.FactoryDAO;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(RegisterServlet.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Entering into RegesiterServlet");
		String name=request.getParameter("fname");
		String username=request.getParameter("uname");
		String dob=request.getParameter("dob");
		String email=request.getParameter("em");
		String password=request.getParameter("pw");
		String address=request.getParameter("address");
		InstaUser is=new InstaUser();
		is.setName(name);
		is.setUsername(username);
		is.setDob(dob);
		is.setEmail(email);
		is.setPassword(password);
		is.setAddress(address);
		//InstaDAOInterface dd=FactoryDAO.createObject();
		//ServletContext sc=getServletContext();
		//sc.setAttribute("uname",username);
		
		InstaDAOInterface dd1=FactoryDAO.createObjectHibernet();
		int i=dd1.createProfile(is);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><style>body{background-color:#e6f9ff;}</style><center><br><br>");
		if(i>0) {
			
			out.println("<font size=5 color=green><b>Profile Created :) <a href=login.html>click here</a>to continue</b></font>");
		}else {
			out.println("<font size=5 color=red><b>Profile Creation failed tyr again !!</b></font>");
		}
		out.println("</center></body></html>");
		
	}

}
