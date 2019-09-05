package project.service;

import java.util.List;

import project.model.*;

public interface FormulaService {
	List<Columns> getColumnsByProject(long projectid);
	List<Block> getBlocks(long projectid);
	long saveColumns(List<Columns> columns);
	long saveBlocks(List<Block> blocks);
	
}
