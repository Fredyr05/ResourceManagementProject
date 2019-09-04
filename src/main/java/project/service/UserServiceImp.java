package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dao.UserDao;
import project.model.Users;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public long save(Users user) {
      return userDao.save(user);
   }

   @Override
   public Users get(long id) {
      return userDao.get(id);
   }

   @Override
   public List<Users> list() {
      return userDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Users user) {
      userDao.update(id, user);
   }

   @Transactional
   @Override
   public void delete(long id) {
      userDao.delete(id);
   }

}
