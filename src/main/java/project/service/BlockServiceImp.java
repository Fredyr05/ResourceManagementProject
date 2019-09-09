package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dao.BlockDao;
import project.model.Block;

@Service
@Transactional(readOnly = true)
public class BlockServiceImp implements BlockService {

	@Autowired
	private BlockDao blockDao;

	@Transactional
	@Override
	public long save(Block block) {
		return blockDao.save(block);
	}

	@Override
	public Block get(long id) {
		return blockDao.get(id);
	}

	@Override
	public List<Block> list() {
		return blockDao.list();
	}

	@Transactional
	@Override
	public void update(long id, Block block) {
		blockDao.update(id, block);
	}

	@Transactional
	@Override
	public void delete(long id) {
		blockDao.delete(id);
	}

}