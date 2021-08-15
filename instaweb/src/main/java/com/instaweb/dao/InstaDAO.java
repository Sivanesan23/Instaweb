package com.instaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.instaweb.entity.InstaUser;

public  class InstaDAO implements InstaDAOInterface {
	private Connection con;
	public InstaDAO() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject","root","Siva@2323");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int createProfile(InstaUser is) {
		int i=0;
		try {
			PreparedStatement pr=con.prepareStatement("insert into instauser value(?,?,?,?,?,?)");
			pr.setString(1, is.getName());
			pr.setString(2, is.getUsername());
			pr.setString(3, is.getDob());
			pr.setString(4, is.getEmail());
			pr.setString(5, is.getPassword());
			pr.setString(6, is.getAddress());
			i=pr.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public InstaUser LoginProfile(InstaUser us) {
		//boolean ww=false;
		InstaUser iu=null;
		try {
			PreparedStatement pr=con.prepareStatement("select name from instauser where username=? and password=?");
			pr.setString(1, us.getUsername());
			pr.setString(2, us.getPassword());
			ResultSet res=pr.executeQuery();
			while(res.next()) {
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return iu;
	}

	public int DeleteProfile(InstaUser id) {
		int i=0;
		try {
			PreparedStatement pr=con.prepareStatement("delete from instauser where email=? and password=?");
			pr.setString(1, id.getEmail());
			pr.setString(2, id.getPassword());
			i=pr.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public InstaUser ViewProfile(InstaUser is) {
		InstaUser bb=null;
		try {
			PreparedStatement pr=con.prepareStatement("select * from instauser where =?");
			pr.setString(1, is.getUsername());
			ResultSet res=pr.executeQuery();
			while(res.next()) {
				bb=new InstaUser();
				bb.setName(res.getString(1));
				bb.setUsername(res.getString(2));
				bb.setDob(res.getString(3));
				bb.setEmail(res.getString(4));
				bb.setPassword(res.getString(5));
				bb.setAddress(res.getString(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bb;
	}

	public InstaUser SearchProfile(InstaUser iu) {
		InstaUser ww=null;
		try {
			PreparedStatement ps=con.prepareStatement("select name,dob,email,address from instauser where username=?");
			ps.setString(1, iu.getUsername());
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				ww=new InstaUser();
				ww.setName(res.getString(1));
				ww.setDob(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ww;
	}

	public int EditProfile(InstaUser us) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<InstaUser> allUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public int checkEmailDAO(InstaUser us) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from InstaUser where email=?");
			ps.setString(1, us.getEmail());
			
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				
				i=1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
