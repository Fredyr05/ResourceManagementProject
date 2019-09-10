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
import project.model.Formula;

@Repository
public class FormulaDaoImp implements FormulaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Formula formula) {
		sessionFactory.getCurrentSession().save(formula);
		return formula.getFormulaId();
	}

	@Override
	public Formula get(long id) {
		return sessionFactory.getCurrentSession().get(Formula.class, id);
	}
	
	@Override
	public Formula getByColumn(long colId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Formula> query = session.createQuery("from Formula as bk where bk.colId = ?", Formula.class);
		query.setParameter("?", colId);
		if(query.getSingleResult()!=null)
			return query.getSingleResult();
		else {
			return null;
		}
	}
	
	@Override
	public List<Formula> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Formula> cq = cb.createQuery(Formula.class);
		Root<Formula> root = cq.from(Formula.class);
		cq.select(root);
		Query<Formula> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Formula formula) {
		Session session = sessionFactory.getCurrentSession();
		Formula temp = session.byId(Formula.class).load(id);
		temp.setEquation(formula.getEquation());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Formula formula = session.byId(Formula.class).load(id);
		session.delete(formula);
	}

}
