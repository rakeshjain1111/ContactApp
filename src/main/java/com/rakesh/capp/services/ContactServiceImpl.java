package com.rakesh.capp.services;

import java.util.List;

import com.rakesh.capp.dao.BaseDAO;
import com.rakesh.capp.domain.Contact;

public class ContactServiceImpl extends BaseDAO implements ContactService {

	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer contactId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer[] contactIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		// TODO Auto-generated method stub
		return null;
	}

}
