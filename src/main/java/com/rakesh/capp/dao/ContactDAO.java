package com.rakesh.capp.dao;

import java.util.List;

import com.rakesh.capp.domain.Contact;

public interface ContactDAO {
	public void save(Contact u);
	public void update(Contact u);
	public void delete(Contact u);
	public void deleteById(Integer contactId);
	public Contact findById(Integer contactId);
	public List<Contact> findAll();
    public List<Contact> findByProperty(String prop, Object propValue);
}
