package project.service;

import java.util.List;

import project.model.Block;

public interface BlockService {

	long save(Block block);

	Block get(long id);

	List<Block> list();

	void update(long id, Block block);

	void delete(long id);
}
