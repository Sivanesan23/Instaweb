package com.instaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instaweb.dao.InstaDAOInterface;
import com.instaweb.entity.InstaUser;
import com.instaweb.utilty.FactoryDAO;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("em");
		String password=request.getParameter("pw");
		InstaUser us=new InstaUser();
		us.setEmail(email);
		us.setPassword(password);
		InstaDAOInterface fd=FactoryDAO.createObjectHibernet();
		int i=fd.DeleteProfile(us);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><center><br><br>");
		if(i>0) {
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/DeleteSuccess");
			rd.forward(request, response);
			//out.println("<font size=5 color=green><b>Profile Deleted</b></font>");
			
		}else {
			out.println("<font size=5 color=red><b>Enter Valide Details</b></font>");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/delete.html");
			rd.include(request, response);
		}
		out.println("</center></body></html>");
	}

}
