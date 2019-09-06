package project.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.dao.BlockDao;
import project.dao.ColumnsDao;
import project.model.Block;
import project.model.Columns;

public class FormulaServiceImp implements FormulaService {
	@Autowired
	private BlockDao blockDao;
	@Autowired
	private ColumnsDao columnsDao;
	
	public List<Columns> getColumnsByProject(long projectid) {
		List<Columns> list;
		list = columnsDao.getByProject(projectid);
		return list;
	}

	public List<Block> getBlocks(long projectid) {
		List<Long> list;
		List<Block> blocklist = new ArrayList<Block>();
		list = columnsDao.getIdsByProject(projectid);
		for(long i:list) {
			blocklist.addAll(blockDao.getByColumn(i));
		}
		return blocklist;
	}

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

	public void saveOrUpdateColumns(List<Columns> columns) {
		for (Columns column : columns) {
			if(column.getColId()==null) {
				columnsDao.save(column);
			}
			else {
				columnsDao.update(column.getColId(),column);
			}
		}
	}

}