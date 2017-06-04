package cn.cat.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import cn.cat.common.DbHelper;
import cn.cat.dao.AdminDao;
import cn.cat.dao.common.DaoException;
import cn.cat.dao.impl.common.BaseDaoImpl;
import cn.cat.entity.Admin;


public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {
	@Override
	public Admin findByName(String name) throws DaoException {
		Admin man = null;
		String sql = "select * from admin where name=?";
		
		Connection conn = null;
		
		conn = DbHelper.getConn();
		try {
			man = qr.query(conn,sql,beanHandler,name);
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally{
			DbUtils.closeQuietly(conn);
		}
		
		return man;
	}

}
