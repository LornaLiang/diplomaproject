package cn.cat.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import cn.cat.common.DbHelper;
import cn.cat.dao.AlbumDao;
import cn.cat.dao.common.DaoException;
import cn.cat.dao.impl.common.BaseDaoImpl;
import cn.cat.entity.Album;

public class AlbumDaoImpl extends BaseDaoImpl<Album> implements AlbumDao{

	public List<Album> findAll(Long... ids) throws DaoException{
		List<Album> list = null;
		
		StringBuilder sql = new StringBuilder("SELECT * FROM ");
		sql.append(getTableName());
		sql.append(" WHERE 1=1 ");
		
		List<Long> params = new ArrayList<Long>();
		int length = ids == null ? 0 : ids.length;
		if(length > 0){
			sql.append(" AND ").append(getPkName()).append(" IN(");
		}
		for(int i = 0; i < length; i++){
			if(i > 0){
				sql.append(",");
			}
			sql.append("?");
			params.add(ids[i]);
		}
		if(length > 0){
			sql.append(")");
		}
		
		System.out.println(sql.toString());
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			list = qr.query(conn, sql.toString(), beanListHandler, params.toArray());
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
		return list;
	}
}
