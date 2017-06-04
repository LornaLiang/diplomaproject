package cn.cat.dao;

import java.util.List;

import cn.cat.dao.common.BaseDao;
import cn.cat.dao.common.DaoException;
import cn.cat.entity.Blog;


public interface BlogDao extends BaseDao<Blog> {
	public List<Blog> findAll(Long... ids) throws DaoException; 
    public List<Blog> find(String type) throws DaoException;
    public List<Blog> finds(String input) throws DaoException;
}
