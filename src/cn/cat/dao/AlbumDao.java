package cn.cat.dao;

import java.util.List;

import cn.cat.dao.common.BaseDao;
import cn.cat.dao.common.DaoException;
import cn.cat.entity.Album;



public interface AlbumDao extends BaseDao<Album>{
	public List<Album> findAll(Long... ids) throws DaoException;

}
