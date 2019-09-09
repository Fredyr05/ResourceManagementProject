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
import project.dao.UserDao;
import project.model.Users;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Users user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public Users get(long id) {
		return sessionFactory.getCurrentSession().get(Users.class, id);
	}

	@Override
	public List<Users> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Users> cq = cb.createQuery(Users.class);
		Root<Users> root = cq.from(Users.class);
		cq.select(root);
		Query<Users> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Users user) {
		Session session = sessionFactory.getCurrentSession();
		Users user2 = session.byId(Users.class).load(id);
		user2.setUsername(user.getUsername());
		user2.setPassword(user.getPassword());
		user2.setEmail(user.getEmail());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Users user = session.byId(Users.class).load(id);
		session.delete(user);
	}

}
