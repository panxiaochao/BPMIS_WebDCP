package bpmis.pxc.system.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bpmis.pxc.system.dao.SystemDao;
import bpmis.pxc.system.service.SystemService;

@Service("systemService")
@Transactional
public class SystemServiceImpl implements SystemService {
	@Resource
	public SystemDao systemDao;

	/*
	 * <---------------implements method----------------->
	 */

	public <T> List<T> ByCrifindQuery(Class<T> clazz) {
		// TODO Auto-generated method stub
		return systemDao.ByCrifindQuery(clazz);
	}

	public <T> List<T> ByCrifindQuery(Class<T> clazz, boolean isAsc,
			String ordername) {
		// TODO Auto-generated method stub
		return systemDao.ByCrifindQuery(clazz, isAsc, ordername);
	}

	public <T> List<T> ByCrifindQuery(Class<T> entityClass,
			Map<String, Integer> parms) {
		// TODO Auto-generated method stub
		return systemDao.ByCrifindQuery(entityClass, parms);
	}

	public <T> void delete(T entity) {
		// TODO Auto-generated method stub
		systemDao.delete(entity);
	}

	public <T> void deleteAll(List<T> entityAll) {
		// TODO Auto-generated method stub
		systemDao.deleteAll(entityAll);
	}

	public <T> void deleteEntityByHql(String hql) {
		// TODO Auto-generated method stub
		systemDao.deleteEntityByHql(hql);
	}

	public <T> void deleteEntityById(Class<T> entityName, String id) {
		// TODO Auto-generated method stub
		systemDao.deleteEntityById(entityName, id);
	}

	public <T> void deleteEntityById(Class<T> entityName, Integer id) {
		// TODO Auto-generated method stub
		systemDao.deleteEntityById(entityName, id);
	}

	public <T> List<T> findByQueryHql(String hql) {
		// TODO Auto-generated method stub
		return systemDao.findByQueryHql(hql);
	}

	public <T> Object getClassById(Class<T> clazz, String id) {
		// TODO Auto-generated method stub
		return systemDao.getClassById(clazz, id);
	}

	public <T> void save(T entity) {
		// TODO Auto-generated method stub
		systemDao.save(entity);
	}

	public <T> void saveAll(List<T> entityAll) {
		// TODO Auto-generated method stub
		systemDao.saveAll(entityAll);
	}

	public <T> void update(T entity) {
		// TODO Auto-generated method stub
		systemDao.update(entity);
	}

	public <T> void saveOrUpdata(T entity) {
		// TODO Auto-generated method stub
		systemDao.saveOrUpdata(entity);
	}

}
