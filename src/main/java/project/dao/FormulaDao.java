package project.dao;

import java.util.List;

import project.model.Formula;

public interface FormulaDao {

	long save(Formula formula);

	Formula get(long id);

	List<Formula> list();

	void update(long id, Formula formula);

	void delete(long id);

}
