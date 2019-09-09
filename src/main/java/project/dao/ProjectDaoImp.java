package project.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.model.Project;

@Repository
public class ProjectDaoImp implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Project project) {
		sessionFactory.getCurrentSession().save(project);
		return project.getProjId();
	}

	@Override
	public Project get(long projId) {
		return sessionFactory.getCurrentSession().get(Project.class, projId);
	}

	@Override
	public List<Project> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Project> cq = cb.createQuery(Project.class);
		Root<Project> root = cq.from(Project.class);
		cq.select(root);
		Query<Project> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long projId, Project project) {
		Session session = sessionFactory.getCurrentSession();
		Project project2 = session.byId(Project.class).getReference(projId);
		project2.setProjName(project.getProjName());
		session.flush();
	}

	@Override
	public void delete(long projId) {
		Session session = sessionFactory.getCurrentSession();
		Project project = session.byId(Project.class).load(projId);
		session.delete(project);
	}
}
