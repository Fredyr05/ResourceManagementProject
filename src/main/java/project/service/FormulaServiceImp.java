package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dao.FormulaDao;
import project.model.Block;
import project.model.Columns;
import project.model.Formula;

@Service
@Transactional(readOnly = true)
public class FormulaServiceImp implements FormulaService {
	
	@Autowired
	private FormulaDao formulaDao;

	@Override
	public List<Columns> getColumnsByProject(long projectid) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Block> getBlocks(long projectid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long saveColumns(List<Columns> columns) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long saveBlocks(List<Block> blocks) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Transactional
	@Override
	public long save(Formula formula) {
		// TODO Auto-generated method stub
		return formulaDao.save(formula);
		
	}

}
