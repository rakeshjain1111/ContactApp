package com.rakesh.capp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.capp.dao.BaseDAO;
import com.rakesh.capp.dao.ContactDAO;
import com.rakesh.capp.domain.Contact;
import com.rakesh.capp.rm.ContactRowMapper;
import com.rakesh.capp.utility.StringUtil;
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {
    
	@Autowired
	private ContactDAO contactDAO;
	@Override
	public void save(Contact c) {
		contactDAO.save(c);
	}

	@Override
	public void update(Contact c) {
		contactDAO.update(c);
	}

	@Override
	public void delete(Integer contactId) {
		contactDAO.deleteById(contactId);
	}

	@Override
	public void delete(Integer[] contactIds) {
		String ids =StringUtil.toCommaSeparateString(contactIds);
		String query = "DELETE FROM contact WHERE contactid IN ("+ids+")";
		super.getJdbcTemplate().update(query);
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return contactDAO.findByProperty("userid", userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		String q = "SELECT contactid ,userid, name, phone, email, address, remark FROM contact WHERE userid = ? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
		List<Contact> clist = super.getJdbcTemplate().query(q, new ContactRowMapper() ,userId);
		return clist;
	}

}
