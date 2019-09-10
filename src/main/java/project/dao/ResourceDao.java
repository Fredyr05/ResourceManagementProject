package project.dao;

import java.util.List;

import project.model.Resource;

public interface ResourceDao {
	
	long save(Resource resource);

	Resource get(long resId);

	List<Resource> list();

	void update(long resId, Resource resource);

	void delete(long resId);
	
	long addToProject(long projId, long resId);
	
	long saveAddedProject(long projId, Resource resource);
	
	List<Resource> getResourcesInProject(long projId);
	
	void deleteResourceByProject(long projId, long resId);

}
