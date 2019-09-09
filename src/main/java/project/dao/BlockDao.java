package project.dao;

import java.util.List;

import project.model.Block;

public interface BlockDao {

	long save(Block block);

	Block get(long id);

	List<Block> list();

	void update(long id, Block column);

	List<Block> getByColumn(long columnId);

	void delete(long id);

}
