package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dao.ResourceDao;
import project.model.Resource;

@Service
@Transactional(readOnly = true)
public class ResourceServiceImp implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;

	@Transactional
	@Override
	public long save(Resource resource) {
		return resourceDao.save(resource);
	}

	@Override
	public Resource get(long resId) {
		return resourceDao.get(resId);
	}

	@Override
	public List<Resource> list() {
		return resourceDao.list();
	}

	@Transactional
	@Override
	public void update(long resId, Resource resource) {
		resourceDao.update(resId, resource);
	}

	@Transactional
	@Override
	public void delete(long resId) {
		resourceDao.delete(resId);
	}
	
	@Transactional
	@Override
	public long addToProject(long projId, long resId) {
		return resourceDao.addToProject(projId, resId);
	}
	
	@Transactional
	@Override
	public long saveAddedProject(long projId, Resource resource) {
		return resourceDao.saveAddedProject(projId, resource);
	}
	
	@Override
	public List<Resource> getResourcesInProject(long projId){
		return resourceDao.getResourcesInProject(projId);
	}
	
	@Transactional
	@Override
	public void deleteResourceByProject(long projId, long resId) {
		resourceDao.deleteResourceByProject(projId, resId);
	}
}
