package bpmis.pxc.system.dao;

import java.util.List;
import java.util.Map;

import org.pxcbpmisframework.core.common.qbc.CriteriaQuery;
import org.pxcbpmisframework.core.page.Page;

public interface SystemDao {
	public <T> void save(T entity);

	public <T> void saveOrUpdata(T entity);

	public <T> void saveAll(List<T> entityAll);

	public <T> void update(T entity);

	public <T> void delete(T entity);

	public <T> void deleteEntityById(Class<T> entityName, String id);

	public <T> void deleteEntityById(Class<T> entityName, Integer id);

	public <T> void deleteEntityByHql(String hql);

	public <T> void deleteAll(List<T> entityAll);

	public <T> void deleteAll(Class<T> entityName, String[] idstr,
			List<T> idlist);

	public <T> List<T> ByCrifindQuery(Class<T> clazz);

	public <T> List<T> ByCrifindQuery(Class<T> clazz, boolean isAsc,
			String ordername);

	public <T> List<T> ByCrifindQuery(Class<T> entityClass,
			Map<String, Integer> parms);

	public Map<?, ?> getPageList(Class<?> clazz, CriteriaQuery cq, Page page);

	public <T> Object getClassById(Class<T> clazz, String id);

	public <T> List<T> findByQueryHql(String hql);
}
