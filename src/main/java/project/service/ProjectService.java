package project.service;

import java.util.List;
import project.model.Project;

public interface ProjectService {

	long save(Project project);

	Project get(long id);

	List<Project> list();

	void update(long id, Project project);

	void delete(long id);

	//void addToProject(long resourceid, long projectid);
}