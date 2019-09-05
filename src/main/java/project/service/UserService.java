package project.service;

import java.util.List;
import project.model.Users;

public interface UserService {

   long save(Users user);
   Users get(long id);
   List<Users> list();
   void update(long id, Users user);
   void delete(long id);
}
