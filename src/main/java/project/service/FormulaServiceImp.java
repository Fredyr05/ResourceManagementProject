package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dao.FormulaDao;
import project.model.Formula;

@Service
@Transactional(readOnly=true)
public class FormulaServiceImp implements FormulaService {

	@Autowired
	private FormulaDao formulaDao;

	@Transactional
	@Override
	public long save(Formula formula) {
		return formulaDao.save(formula);
	}

	@Override
	public Formula get(long id) {
		return formulaDao.get(id);
	}

	@Override
	public List<Formula> list() {
		return formulaDao.list();
	}

	@Transactional
	@Override
	public void update(long id, Formula formula) {
		formulaDao.update(id, formula);
	}

	@Transactional
	@Override
	public void delete(long id) {
		formulaDao.delete(id);
	}

}