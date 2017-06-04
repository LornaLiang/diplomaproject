package cn.cat.dao;


import java.util.List;
import cn.cat.entity.Comment;
import cn.cat.dao.common.BaseDao;
import cn.cat.dao.common.DaoException;


public interface CommentDao extends BaseDao<Comment> {
	public List<Comment> findAll(Long... ids) throws DaoException;
    public List<Comment> find(Long c_id)throws DaoException;
}
