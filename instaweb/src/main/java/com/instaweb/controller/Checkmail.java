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

public class Checkmail extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		InstaUser us=new InstaUser();
		us.setEmail(email);
		InstaDAOInterface dd=FactoryDAO.createObject();
		//InstaDAOInterface dd1=FactoryDAO.createObjectHibernet();
		int i=dd.checkEmailDAO(us);
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		  out.println("<html><body><center><br><br>");
		  if(i>0) {
			  out.println("email already exist");
		  }
		  else {
			  out.println("valid mail");
		  }
		  out.println("</center></body></html>");
	}

}
