package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dao.ProjectDao;
import project.model.Project;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImp implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Transactional
	@Override
	public long save(Project project) {
		return projectDao.save(project);
	}

	@Override
	public Project get(long projId) {
		return projectDao.get(projId);
	}

	@Override
	public List<Project> list() {
		return projectDao.list();
	}

	@Transactional
	@Override
	public void update(long projId, Project project) {
		projectDao.update(projId, project);
	}

	@Transactional
	@Override
	public void delete(long projId) {
		projectDao.delete(projId);
	}
}
