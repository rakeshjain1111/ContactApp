package com.rakesh.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.rakesh.capp.domain.Contact;
import com.rakesh.capp.rm.ContactRowMapper;
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	@Override
	public void save(Contact c) {
		String query = "insert into contact(userid, name,phone,email,address,remark)"+"values(:userid, :name, :phone, :email, :address, :remark)";
		Map m = new HashMap();
		m.put("userid",c.getUserId() );
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		
		KeyHolder kh =new GeneratedKeyHolder();
		SqlParameterSource ps= new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(query, ps ,kh);
		c.setContactId(kh.getKey().intValue());
	}

	@Override
	public void update(Contact c) {
		
		String query = "update contact set "+"name=:name,"+"phone=:phone,"+"email=:email,"+"address=:address,"+"remark=:remark where contactid=:contactid";
		Map m = new HashMap();
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		m.put("contactid", c.getContactId());
		super.getNamedParameterJdbcTemplate().update(query, m);
	}

	@Override
	public void delete(Contact c) {
          this.deleteById(c.getContactId());
	}

	@Override
	public void deleteById(Integer contactId) {
		String query = "delete from contact where contactid=?";
		getJdbcTemplate().update(query,contactId);
	}

	@Override
	public Contact findById(Integer contactId) {
		String query = "SELECT contactid, userid, name, phone, email, address, remark FROM contact WHERE contactid=?";
		Contact contact=  super.getJdbcTemplate().queryForObject(query,new ContactRowMapper(),contactId);
		return contact;
	}

	@Override
	public List<Contact> findAll() {
       String query = "SELECT contactid, userid, name, phone, email, address, remark FROM contact ";
       List<Contact> contacts =getJdbcTemplate().query(query, new ContactRowMapper());
		return contacts ;
	}

	@Override
	public List<Contact> findByProperty(String prop, Object propValue) {
		String query = "SELECT contactid, userid, name, phone, email, address, remark FROM contact WHERE "+prop+"= ?";
		List<Contact> contacts=  super.getJdbcTemplate().query(query,new ContactRowMapper(),propValue);
		return contacts;
	}

}
