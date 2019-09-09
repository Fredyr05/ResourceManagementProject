package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.model.Users;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Users user) {
		//sessionFactory.getCurrentSession().save(user);
		String username = user.getUsername();
		if(findByUsername(username)) {
			System.out.println("USER Already exist.");
			return 0;
		}
		else {
			sessionFactory.getCurrentSession().save(user);
			return user.getId();
		}
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

	@Override
	public boolean findByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			Connection con = sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
			sessionFactory.getCurrentSession();
			String query = "SELECT username FROM Users where username = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,username);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			if(!rs.next()) {
				return false;
			}
			else {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
