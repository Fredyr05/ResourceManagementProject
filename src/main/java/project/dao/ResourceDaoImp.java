package project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.model.Project;
import project.model.Resource;

@Repository
public class ResourceDaoImp implements ResourceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Resource resource) {
		sessionFactory.getCurrentSession().save(resource);
		return resource.getResId();
	}

	@Override
	public Resource get(long resId) {
		return sessionFactory.getCurrentSession().get(Resource.class, resId);
	}

	@Override
	public List<Resource> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Resource> cq = cb.createQuery(Resource.class);
		Root<Resource> root = cq.from(Resource.class);
		cq.select(root);
		Query<Resource> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long resId, Resource resource) {
		Session session = sessionFactory.getCurrentSession();
		Resource resource2 = session.byId(Resource.class).getReference(resId);
		resource2.setResCode(resource.getResCode());
		resource2.setResName(resource.getResName());
		session.flush();
	}

	@Override
	public void delete(long resId) {
		Session session = sessionFactory.getCurrentSession();
		Resource resource = session.byId(Resource.class).load(resId);
		session.delete(resource);
	}
	
	@Override
	public long addToProject(long projId, long resId) {
		Session session = sessionFactory.getCurrentSession();
		Project project = (Project)session.get(Project.class, projId);
		Resource resource = (Resource)session.get(Resource.class, resId);
		project.getResources().add(resource);
		session.save(project);
		return project.getProjId();
	}
	
	@Override
	public long saveAddedProject(long projId, Resource resource) {
		sessionFactory.getCurrentSession().save(resource);
		return resource.getResId();
	}
	
	@Override
	public List<Resource> getResourcesInProject(long projId) {
		Project project = sessionFactory.getCurrentSession().getReference(Project.class, projId);
		List<Resource> resources = new ArrayList<Resource>();
		Set<Resource> resInProj = project.getResources();
		for(Resource resource : resInProj) {
			resources.add(resource);
		}
		return resources;
	}
	
	@Override
	public void deleteResourceByProject(long projId, long resId) {
		Session session = sessionFactory.getCurrentSession();
		Project project = session.byId(Project.class).getReference(projId);
		Resource resource = session.byId(Resource.class).getReference(resId);
		project.getResources().remove(resource);
		session.update(project);
	}

}
