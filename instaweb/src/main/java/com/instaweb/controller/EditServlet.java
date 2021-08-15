package com.instaweb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instaweb.dao.InstaDAOInterface;
import com.instaweb.entity.InstaUser;
import com.instaweb.utilty.FactoryDAO;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BufferedReader br;
	public EditServlet() {
		br=new BufferedReader (new InputStreamReader(System.in));
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String email=request.getParameter("em");
		//String password=request.getParameter("pw");
		//HttpSession sc=request.getSession(true);
		ServletContext sc=getServletContext();
		Object oo=sc.getAttribute("id");
		InstaUser us=new InstaUser();
		System.out.println(us.getName());
		us.setEmail(oo.toString());
		//us.setEmail(email);
		//us.setPassword(password);
		InstaDAOInterface ob=FactoryDAO.createObjectHibernet();
		InstaUser iu=ob.ViewProfile(us);
		System.out.println(iu.getName());
		String str = iu.getName();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><style>body{background-color:#e6f9ff;}</style><center><br><br>");
		if(iu!=null) {
			
			out.println("<p>Edit Profile</p><br>");
			out.println("<table>");
			out.println("<form metho=post action='EditProfile'>");
			out.println("<tr><td>Name :</td><td> <input type=text name=nm value="+str+"></td></tr>");
			out.println("<tr><td>UserName : </td><td><input type=text name=unm value="+iu.getUsername()+"></td></tr>");
			out.println("<tr><td>DOB :</td><td> <input type=date name=dobn value="+iu.getDob()+"></td></tr>");
			out.println("<tr><td>Password :</td><td> <input type=text name=pwn value="+iu.getPassword()+"></td></tr>");
			//out.println("<br>Email :<input type=email name=em value="+iu.getEmail()+">");
			out.println("<tr><td>Address :</td><td><input type=text name=ad value="+iu.getAddress()+"></td></tr>");
			out.println("<tr><td><input type=submit value=Edit></td></tr>");
			out.println("</form>");
			out.println("</table>");
		}else {
			out.println("<font size=5 color=red><b> failed tyr again !!</b></font>");
		}
		out.println("</center></body></html>");
		
	}

}
