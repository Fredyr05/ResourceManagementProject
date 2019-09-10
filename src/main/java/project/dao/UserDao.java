package project.dao;

import java.util.List;
import project.model.Users;

public interface UserDao {

	long save(Users user);

	Users get(long id);

	List<Users> list();

	void update(long id, Users user);

	void delete(long id);
	
	boolean findByUsername(String username);

}