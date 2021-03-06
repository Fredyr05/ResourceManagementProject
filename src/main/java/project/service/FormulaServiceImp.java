package project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import project.dao.BlockDao;
import project.dao.ColumnsDao;
import project.dao.FormulaDao;
import project.model.Block;
import project.model.Columns;
import project.model.Formula;
@Service
@Transactional(readOnly=true)
public class FormulaServiceImp implements FormulaService {

	@Autowired
	private BlockDao blockDao;
	@Autowired
	private ColumnsDao columnsDao;
	@Autowired
	private FormulaDao formulaDao;
	@Override
	public List<Columns> getColumnsByProject(long projectid) {
		List<Columns> list;
		list = columnsDao.getByProject(projectid);
		return list;
	}
	@Override
	public List<Block> getBlocks(long projectid) {
		List<Long> list;
		List<Block> blocklist = new ArrayList<Block>();
		list = columnsDao.getIdsByProject(projectid);
		for(long i:list) {
			blocklist.addAll(blockDao.getByColumn(i));
		}
		return blocklist;
	}
	@Override
	public List<Formula> getFormulas(long projectid){
		List<Long> list;
		List<Formula> formulalist = new ArrayList<Formula>();
		list = columnsDao.getIdsByProject(projectid);
		for(long i:list) {
			formulalist.add(formulaDao.getByColumn(i));
		}
		return formulalist;
	}
	@Transactional
	@Override
	public void saveOrUpdateBlocks(List<Block> blocks) {
		for (Block block : blocks) {
			if(block.getBlockId()==null) {
				blockDao.save(block);
			}
			else {
				blockDao.update(block.getBlockId(),block);
			}
		}
			
	}
	@Transactional
	@Override
	public void saveOrUpdateColumns(long projectid,List<Columns> columns) {
		for (Columns column : columns) {
			if(column.getColId()==null) {
				
				columnsDao.save(projectid,column);
			}
			else {
				columnsDao.update(column.getColId(),column);
			}
		}
	}
	@Transactional
	@Override
	public void saveOrUpdateFormulas(List<Formula> formulas) {
		for (Formula formula : formulas) {
			if(formula.getFormulaId()==null) {
				formulaDao.save(formula);
			}
			else {
				formulaDao.update(formula.getFormulaId(),formula);
			}
		}
	}

}