package bpmis.pxc.system.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bpmis.pxc.system.dao.jdbc.JdbcTemplateDao;

@Repository("jdbcTemplateDao")
@Transactional
public class JdbcTemplateIml implements JdbcTemplateDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}

	/* <---------------implements method--------------------> */
	public void execute(String sql) {
		// TODO Auto-generated method stub

	}

	public int queryForInt(String sql) {
		// TODO Auto-generated method stub
		return queryForInt(sql, null);
	}

	public int queryForInt(String sql, Object[] args) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(sql, args, Integer.class);
	}

	public String queryForString(String sql) {
		// TODO Auto-generated method stub
		return queryForString(sql, null);
	}

	public String queryForString(String sql, Object[] args) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(sql, args, String.class);
	}

	public <T> List<T> queryForList(String sql, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return queryForList(sql, null, entityClass);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> queryForList(String sql, Object[] args,
			Class<T> entityClass) {
		// TODO Auto-generated method stub
		return (List<T>) jdbcTemplate.queryForList(sql, args,
				new BeanPropertyRowMapper<T>(entityClass));
	}

}
