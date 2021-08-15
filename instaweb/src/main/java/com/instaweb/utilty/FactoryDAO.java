package com.instaweb.utilty;

import com.instaweb.dao.InstaDAO;
import com.instaweb.dao.InstaDAOInterface;
import com.instaweb.dao.InstauserDAOHibernet;

public class FactoryDAO {

	public static InstaDAOInterface createObject() {
		
		return new InstaDAO();
	}
public static InstaDAOInterface createObjectHibernet() {
		
		return new InstauserDAOHibernet();
	}

}
