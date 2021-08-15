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

public class EditProfile extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc=getServletContext();
		Object ob=sc.getAttribute("id");
		//System.out.println(ob);
		String email=null;
		email=ob.toString();
		//System.out.println(email);
		String name=request.getParameter("nm");
		String username=request.getParameter("unm");
		String dob=request.getParameter("dobn");
		String password=request.getParameter("pwn");
		String address=request.getParameter("ad");
		InstaUser is=new InstaUser();
		is.setName(name);
		is.setUsername(username);
		is.setDob(dob);
		is.setEmail(email);
		is.setPassword(password);
		is.setAddress(address);
		//InstaDAOInterface dd=FactoryDAO.createObject();
		InstaDAOInterface dd1=FactoryDAO.createObjectHibernet();
		int i=dd1.EditProfile(is);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><center><br><br>");
		if(i>0) {
			out.println("<font size=5 color=green><b>Profile Edited :)</b></font>");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/LoginSuccess");
			rd.forward(request, response);
		}else {
			out.println("<font size=5 color=red><b>Profile Not Edited !!</b></font>");
		}
		out.println("</center></body></html>");
	}

}
