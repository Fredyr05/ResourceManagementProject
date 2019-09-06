package project.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import project.model.Block;

public class BlockDaoImp implements BlockDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Block block) {
		sessionFactory.getCurrentSession().save(block);
		return block.getBlockId();
	}

	@Override
	public Block get(long id) {
		return sessionFactory.getCurrentSession().get(Block.class, id);
	}

	@Override
	public List<Block> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Block> cq = cb.createQuery(Block.class);
		Root<Block> root = cq.from(Block.class);
		cq.select(root);
		Query<Block> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Block block) {
		Session session = sessionFactory.getCurrentSession();
		Block block2 = session.byId(Block.class).load(id);
		block2.setValue(block.getValue());
		session.flush();
	}
	@Override
	public List<Block> getByColumn(long columnId){
		Session session = sessionFactory.getCurrentSession();
		Query<Block> query = session.createQuery("from Block as bk where bk.colId = ?");
		query.setParameter("?",columnId);
		return query.getResultList();
		
	}
	
	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Block block = session.byId(Block.class).load(id);
		session.delete(block);
	}
	

}
