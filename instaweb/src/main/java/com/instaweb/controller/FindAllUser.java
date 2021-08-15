package com.instaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instaweb.dao.InstaDAOInterface;
import com.instaweb.entity.InstaUser;
import com.instaweb.utilty.FactoryDAO;

public class FindAllUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		PrintWriter out=response.getWriter();
		InstaDAOInterface dd=FactoryDAO.createObjectHibernet();
		List<InstaUser> ff=dd.allUser();
		String json=null;
		ObjectMapper objectMapper =new ObjectMapper();
		try {
			json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ff);
			//System.out.println(json);
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.println(json);
	}

}
