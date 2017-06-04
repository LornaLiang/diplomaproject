package cn.cat.dao;

import java.util.List;

import cn.cat.dao.common.BaseDao;
import cn.cat.dao.common.DaoException;
import cn.cat.entity.Info;


public interface InfoDao  extends BaseDao<Info>{
	public List<Info> findAll(Long... ids) throws DaoException;
	public Info findC(int count) throws DaoException;
	
	
}
