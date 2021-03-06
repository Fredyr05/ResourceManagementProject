package project.dao;

import java.util.*;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import project.model.Project;
import project.model.Columns;
@Repository
public class ColumnsDaoImp implements ColumnsDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(long projectid,Columns columns) {
		
		Session session = sessionFactory.getCurrentSession();
		Project project = (Project)session.get(Project.class, projectid);
		columns.setProject(project);
		session.save(columns);
		return columns.getColId();
	}

	@Override
	public Columns get(long id) {
		return sessionFactory.getCurrentSession().get(Columns.class, id);
	}

	@Override
	public List<Columns> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Columns> cq = cb.createQuery(Columns.class);
		Root<Columns> root = cq.from(Columns.class);
		cq.select(root);
		Query<Columns> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Columns columns) {
		Session session = sessionFactory.getCurrentSession();
		Columns columns2 = session.byId(Columns.class).load(id);
		columns2.setColName(columns.getColName());
		columns2.setType(columns.getType());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Columns columns = session.byId(Columns.class).load(id);
		session.delete(columns);
	}

	@Override
	public List<Columns> getByProject(long projectid) {
		Project project = sessionFactory.getCurrentSession().getReference(Project.class, projectid);
		Set<Columns> columnsset = project.getColumns();
	    ArrayList<Columns> columnlist=new ArrayList<Columns>();
	    for(Columns column: columnsset) {
	    	columnlist.add(column);
	    }
		return columnlist;
	}

	@Override
	public List<Long> getIdsByProject(long projectid) {
		Project project = sessionFactory.getCurrentSession().getReference(Project.class, projectid);
		Set<Columns> columnsset = project.getColumns();
	    ArrayList<Long> columnlist=new ArrayList<Long>();
	    for(Columns column: columnsset) {
	    	columnlist.add(column.getColId());
	    }
	    return columnlist;
	}

}
