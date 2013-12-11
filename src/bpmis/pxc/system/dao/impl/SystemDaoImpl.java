package bpmis.pxc.system.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pxcbpmisframework.core.exception.BusinessException;
import org.springframework.stereotype.Repository;

import bpmis.pxc.system.dao.SystemDao;

@Repository("systemDao")
public class SystemDaoImpl implements SystemDao {
	private static final Logger logger = Logger.getLogger(SystemDaoImpl.class);
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * <---------------implements method----------------->
	 */

	public <T> List<T> ByCrifindQuery(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> ByCrifindQuery(Class<T> clazz, boolean isAsc,
			String ordername) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> ByCrifindQuery(Class<T> entityClass,
			Map<String, Integer> parms) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> void delete(T entity) {
		// TODO Auto-generated method stub

	}

	public <T> void deleteAll(List<T> entityAll) {
		// TODO Auto-generated method stub

	}

	public <T> void deleteEntityByHql(String hql) {
		// TODO Auto-generated method stub

	}

	public <T> void deleteEntityById(Class<T> entityName, String id) {
		// TODO Auto-generated method stub

	}

	public <T> void deleteEntityById(Class<T> entityName, Integer id) {
		// TODO Auto-generated method stub

	}

	public <T> List<T> findByQueryHql(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Object getClassById(Class<T> clazz, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Title: save
	 */
	public <T> void save(T entity) {
		// TODO Auto-generated method stub
		try {
			getSession().save(entity);
			getSession().flush();
		} catch (RuntimeException e) {
			logger.error(e);
			throw new BusinessException(e);
		}
	}

	public <T> void saveAll(List<T> entityAll) {
		// TODO Auto-generated method stub

	}

	public <T> void saveOrUpdata(T entity) {
		// TODO Auto-generated method stub

	}

}
