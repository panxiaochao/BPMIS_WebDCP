package bpmis.pxc.system.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: SystemService
 * @Description: TODO(系统类接口)
 * @author Mr_Pxc
 * @date 2013-12-11 上午10:59:39
 * @project_name：BPMIS_WebDCP
 * @version 1.0
 */
public interface SystemService {

	public <T> void save(T entity);

	public <T> void saveOrUpdata(T entity);

	public <T> void saveAll(List<T> entityAll);

	public <T> void delete(T entity);

	public <T> void deleteEntityById(Class<T> entityName, String id);

	public <T> void deleteEntityById(Class<T> entityName, Integer id);

	public <T> void deleteEntityByHql(String hql);

	public <T> void deleteAll(List<T> entityAll);

	public <T> List<T> ByCrifindQuery(Class<T> clazz);

	public <T> List<T> ByCrifindQuery(Class<T> clazz, boolean isAsc,
			String ordername);

	public <T> List<T> ByCrifindQuery(Class<T> entityClass,
			Map<String, Integer> parms);

	public <T> Object getClassById(Class<T> clazz, String id);

	public <T> List<T> findByQueryHql(String hql);
}
