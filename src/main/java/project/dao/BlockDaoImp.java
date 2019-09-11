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
import project.model.Block;
import project.model.Resource;
import project.model.Columns;

@Repository
public class BlockDaoImp implements BlockDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Block block) {
		Session session = sessionFactory.getCurrentSession();
		long colId = block.getColumns().getColId();
		long resId = block.getResource().getResId();
		Columns columns = (Columns)session.get(Columns.class,colId);
		Resource resource = (Resource)session.get(Resource.class,resId);
		block.setColumns(columns);
		block.setResource(resource);
		session.save(block);
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
	public List<Block> getByColumn(long columnId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Block> query = session.createQuery("from Block as bk where bk.colId = ?", Block.class);
		query.setParameter("?", columnId);
		if(query.getResultList()!=null)
			return query.getResultList();
		else {
			return null;
		}
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Block block = session.byId(Block.class).load(id);
		session.delete(block);
	}

}
