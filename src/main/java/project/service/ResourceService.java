package project.service;

import java.util.List;
import project.model.Resource;

public interface ResourceService {

   long save(Resource user);
   Resource get(long id);
   List<Resource> list();
   void update(long id, Resource resource);
   void delete(long id);
    //use to add a resource to a project   
}
