package project.service;

import java.util.List;

import project.model.Columns;

public interface ColumnsService {

	long save(Columns columns);

	Columns get(long id);

	List<Columns> list();

	void update(long id, Columns columns);

	void delete(long id);
}
