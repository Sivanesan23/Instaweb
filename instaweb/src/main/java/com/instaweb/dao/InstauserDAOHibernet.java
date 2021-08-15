package com.instaweb.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.instaweb.entity.InstaUser;

public class InstauserDAOHibernet implements InstaDAOInterface {
	private SessionFactory sf;
	public InstauserDAOHibernet() {
		sf=new Configuration().configure().buildSessionFactory();
	}
	public int createProfile(InstaUser is) {
		int i=0;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(is);
		t.commit();
		i=1;
		return i;
	}
	
	public InstaUser LoginProfile(InstaUser us) {
		//boolean b=false;
		Session s=sf.openSession();
		Query q=s.createQuery("from InstaUser us where us.email='"+us.getEmail()+"' and us.password='"+us.getPassword()+"'");
		/*List<InstaUser> ff=q.getResultList();
		if(ff.size()>0) {
			b=true;
		}
		return b;*/
		InstaUser iu=(InstaUser)q.getSingleResult();
		return iu;
	}

	public int DeleteProfile(InstaUser us) {
		int i=0;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("delete InstaUser us where us.email='"+us.getEmail()+"' and us.password='"+us.getPassword()+"'");
		i=q.executeUpdate();
		t.commit();
		i=1;
		return i;
	}

	public InstaUser ViewProfile(InstaUser us) {
		//us.getEmail();
		Session s=sf.openSession();
		Query q=s.createQuery("from InstaUser us where us.email='"+us.getEmail()+"'");
		//Query q=s.createQuery("from InstaUser us where us.email='"+us.getEmail()+"' and us.password='"+us.getPassword()+"'");
		InstaUser iu=(InstaUser)q.getSingleResult();
		return iu;
	}

	public InstaUser SearchProfile(InstaUser us) {
		Session s=sf.openSession();
		Query q=s.createQuery("from InstaUser us where us.username='"+us.getUsername()+"'");
		InstaUser iu=(InstaUser)q.getSingleResult();
		return iu;
	}

	public int EditProfile(InstaUser us) {
		int i=0;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("update InstaUser us set us.name= :Name,us.username= :Username,us.dob= :Dob,us.password= :Password,us.address= :Address where us.email= :Email");
		
		q.setParameter("Name", us.getName());
		q.setParameter("Username", us.getUsername());
		q.setParameter("Dob", us.getDob());
		q.setParameter("Password", us.getPassword());
		q.setParameter("Address", us.getAddress());
		q.setParameter("Email", us.getEmail());
	
		i=q.executeUpdate();
		t.commit();
		i=1;
		return i;
	}
	public List<InstaUser> allUser() {
		Session s=sf.openSession();
		Query q=s.createQuery("from InstaUser us");
		return q.getResultList();
	}
	public int checkEmailDAO(InstaUser us) {
		int i=0;
		try {
			Session s=sf.openSession();
			Query q=s.createQuery("from InstaUser us where us.email='"+us.getEmail()+"'");
			i=(Integer) q.getSingleResult();
			i=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
	

