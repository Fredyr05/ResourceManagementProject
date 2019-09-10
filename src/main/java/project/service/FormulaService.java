package project.service;

import java.util.List;

import project.model.*;

public interface FormulaService {

	List<Columns> getColumnsByProject(long projectid);
	List<Block> getBlocks(long projectid);
	List<Formula> getFormulas(long projectid);
	void saveOrUpdateBlocks(List<Block> blocks);
	void saveOrUpdateColumns(List<Columns> columns) ;
	void saveOrUpdateFormulas(List<Formula> formulas);
}
