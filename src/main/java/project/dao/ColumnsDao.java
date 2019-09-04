package project.dao;

import java.util.List;

import project.model.Columns;

public interface ColumnsDao {

	long save(Columns columns);

	Columns get(long id);

	List<Columns> list();

	void update(long id, Columns column);

	void delete(long id);

}
