package project.dao;

import java.util.List;

import project.model.Project;

public interface ProjectDao {

	long save(Project project);

	Project get(long projId);

	List<Project> list();

	void update(long projId, Project project);

	void delete(long projId);

}
