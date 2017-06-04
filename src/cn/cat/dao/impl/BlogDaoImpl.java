package cn.cat.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import cn.cat.common.DbHelper;
import cn.cat.dao.BlogDao;
import cn.cat.dao.common.DaoException;
import cn.cat.dao.impl.common.BaseDaoImpl;
import cn.cat.entity.Blog;



public class BlogDaoImpl extends BaseDaoImpl<Blog> implements BlogDao{

	public List<Blog> findAll(Long... ids) throws DaoException{
		List<Blog> list = null;
		
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
	//根据类型查询
	public List<Blog> find(String type) throws DaoException{
        List<Blog> list = null;
		
		StringBuilder sqls = new StringBuilder("SELECT * FROM ");
		sqls.append(getTableName());
		sqls.append(" WHERE type= ? ");
	
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			
			list= qr.query(conn, sqls.toString(), beanListHandler, type);
		}catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return list;
	}
	
	//模糊查询
	public List<Blog> finds(String input) throws DaoException{
        List<Blog> list = null;
		
		StringBuilder sqlss = new StringBuilder("SELECT * FROM ");
		sqlss.append(getTableName());
		sqlss.append(" WHERE title like ?");
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			
			list= qr.query(conn, sqlss.toString(), beanListHandler, input);
		}catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return list;
	}
	
	
	
	
		
	}

