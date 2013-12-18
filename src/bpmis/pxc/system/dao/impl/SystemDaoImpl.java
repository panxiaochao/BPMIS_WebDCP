package bpmis.pxc.system.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
	/**
	 * @Title: delete
	 */
	public <T> void delete(T entity) {
		// TODO Auto-generated method stub
		try {
			getSession().delete(entity);
			getSession().flush();
		} catch (RuntimeException e) {
			logger.error(e);
			throw new BusinessException(e);
		} finally {
			// s.close();
		}
	}

	/**
	 * @Title: deleteAll
	 */
	public <T> void deleteAll(List<T> entityAll) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < entityAll.size(); i++) {
				getSession().delete(entityAll.get(i));
				getSession().flush();
			}
		} catch (RuntimeException e) {
			logger.error(e);
			throw new BusinessException(e);
		} finally {
			// s.close();
		}
	}

	/**
	 * @Title: deleteEntityByHql
	 */
	public <T> void deleteEntityByHql(String hql) {
		// TODO Auto-generated method stub

	}

	/**
	 * @Title: deleteEntityById
	 */
	public <T> void deleteEntityById(Class<T> entityName, String id) {
		// TODO Auto-generated method stub
		deleteEntityById(entityName, Integer.parseInt(id));
	}

	/**
	 * @Title: deleteEntityById
	 */
	public <T> void deleteEntityById(Class<T> entityName, Integer id) {
		// TODO Auto-generated method stub
		try {
			Object object = getClassById(entityName, id);
			getSession().delete(object);
			getSession().flush();
		} catch (RuntimeException e) {
			logger.error(e);
			throw new BusinessException(e);
		} finally {
			// s.close();
		}
	}

	/**
	 * @Title: findByQueryHql
	 */
	public <T> List<T> findByQueryHql(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Title: getClassById
	 */
	public <T> Object getClassById(Class<T> clazz, String id) {
		// TODO Auto-generated method stub
		return getClassById(clazz, Integer.parseInt(id));
	}

	/**
	 * @Title: getClassById
	 */
	public <T> Object getClassById(Class<T> clazz, Integer id) {
		// TODO Auto-generated method stub
		Object obj = null;
		try {
			obj = getSession().load(clazz, id);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e);
		} finally {
			// s.close();
		}
		return obj;
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

	/**
	 * @Title: saveAll
	 */
	public <T> void saveAll(List<T> entityAll) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < entityAll.size(); i++) {
				getSession().save(entityAll.get(i));
				getSession().flush();
			}
		} catch (RuntimeException e) {
			logger.error(e);
			throw new BusinessException(e);
		}
	}

	/**
	 * @Title: saveOrUpdata
	 */
	public <T> void saveOrUpdata(T entity) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(entity);
			getSession().flush();
		} catch (RuntimeException e) {
			logger.error(e);
			throw new BusinessException(e);
		} finally {
			// s.close();
		}
	}

	/**
	 * @Title: update
	 */
	public <T> void update(T entity) {
		// TODO Auto-generated method stub
		try {
			getSession().update(entity);
			getSession().flush();
		} catch (RuntimeException e) {
			logger.error(e);
			throw new BusinessException(e);
		} finally {
			// s.close();
		}
	}

	// ******************************************************************
	// ---------------------下面采用Criteria方法--------------------------
	// ******************************************************************
	private DetachedCriteria detachedCriteria;

	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}

	/**
	 * 得到Criteria
	 * 
	 * @Title: getCriteria
	 */
	public <T> Criteria getCriteria(Class<T> clazz) {
		return getSession().createCriteria(clazz);
	}

	/**
	 * @Title: ByCrifindQuery
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> ByCrifindQuery(Class<T> clazz) {
		// TODO Auto-generated method stub
		return getCriteria(clazz).list();
	}

	/**
	 * @Title: ByCrifindQuery
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> ByCrifindQuery(Class<T> clazz, boolean isAsc,
			String ordername) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(clazz);
		if (isAsc)
			criteria.addOrder(Order.asc(ordername));
		else
			criteria.addOrder(Order.desc(ordername));
		return criteria.list();
	}

	/**
	 * @Title: ByCrifindQuery
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> ByCrifindQuery(Class<T> entityClass,
			Map<String, Integer> parms) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(entityClass);
		Set<String> setkey = parms.keySet();
		for (Object key : setkey) {
			Integer value = parms.get(key);
			criteria.add(Restrictions.eq(key.toString(), value));
		}
		return criteria.list();
	}

}
