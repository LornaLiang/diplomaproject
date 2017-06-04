package cn.cat.dao;

import cn.cat.dao.common.BaseDao;
import cn.cat.dao.common.DaoException;
import cn.cat.entity.Admin;
import cn.cat.entity.common.Entity;

public interface AdminDao extends BaseDao<Admin>{
	public Admin findByName(String name) throws DaoException;

}
