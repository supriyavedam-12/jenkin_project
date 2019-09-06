package com.facebook2.dao;

import com.facebook2.entity.FacebookEmployee;

public class FacebookDAO implements FacebookDAOInterface {
	private FacebookDAO() {}

	public static FacebookDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new FacebookDAO();
	}

	@Override
	public int createProfileDAO(FacebookEmployee fe) {
		// TODO Auto-generated method stub
		return 1;
	}

}
