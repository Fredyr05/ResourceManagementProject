package project.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import project.model.Columns;

public interface ColumnsDao {

	long save(long projectid,Columns columns);

	Columns get(long id);

	List<Columns> list();

	void update(long id, Columns column);

	List<Columns> getByProject(long projectid);

	List<Long> getIdsByProject(long projectid);// return column Ids

	void delete(long id);

}
