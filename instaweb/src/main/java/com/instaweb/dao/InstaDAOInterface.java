package com.instaweb.dao;

import java.util.List;

import com.instaweb.entity.InstaUser;

public interface InstaDAOInterface {

	int createProfile(InstaUser us);

	InstaUser LoginProfile(InstaUser us);

	int DeleteProfile(InstaUser us);

	InstaUser ViewProfile(InstaUser is);

	InstaUser SearchProfile(InstaUser us);

	int EditProfile(InstaUser us);
	
	int checkEmailDAO(InstaUser us);

	List<InstaUser> allUser();

	

	

}
