package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dao.ColumnsDao;
import project.model.Columns;

@Service
@Transactional(readOnly = true)
public class ColumnsServiceImp implements ColumnsService {

	@Autowired
	private ColumnsDao columnsDao;

	@Transactional
	@Override
	public long save(Columns columns) {
		return columnsDao.save(columns);
	}

	@Override
	public Columns get(long id) {
		return columnsDao.get(id);
	}

	@Override
	public List<Columns> list() {
		return columnsDao.list();
	}

	@Transactional
	@Override
	public void update(long id, Columns columns) {
		columnsDao.update(id, columns);
	}

	@Transactional
	@Override
	public void delete(long id) {
		columnsDao.delete(id);
	}

}