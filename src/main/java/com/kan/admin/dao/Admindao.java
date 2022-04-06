package com.kan.admin.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.kan.admin.dao.SQLSelectorWebService;
import com.kan.admin.vo.State;

@Repository
public class Admindao {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public long queryForSave(String query,Object[] param) {
		return jdbcTemplate.update(SQLSelectorWebService.getQuery(query),param);
    }
	
	public List findAll(String query, Class returnClassType) {
	    return jdbcTemplate.query(SQLSelectorWebService.getQuery(query),new BeanPropertyRowMapper(returnClassType));
	 }
	
	public Object findById(String query,Object[] param, Class returnClassType) {
	    return jdbcTemplate.queryForObject(SQLSelectorWebService.getQuery(query),param,new BeanPropertyRowMapper(returnClassType));
	 }
	
	public void delete(String query,Object[] param) {
	     jdbcTemplate.update(SQLSelectorWebService.getQuery(query),param);
	 }
	public long queryForUpdate(String query,Object[] param) {
//		return param;
		return jdbcTemplate.update(SQLSelectorWebService.getQuery(query),param[0],param[1]);
    }
}
