package project.service;

import java.util.List;
import project.model.Resource;

public interface ResourceService {

	long save(Resource user);

	Resource get(long id);

	List<Resource> list();

	void update(long id, Resource resource);

	void delete(long id);

	long addToProject(long projId, long resId);

	long saveAddedProject(long projId, Resource resource);
	
	List<Resource> getResourcesInProject(long projId);
	
	void deleteResourceByProject(long projId, long resId);

}
