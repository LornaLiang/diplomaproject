package cn.cat.dao.impl.common;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.cat.common.DbHelper;
import cn.cat.dao.common.BaseDao;
import cn.cat.dao.common.DaoException;
import cn.cat.entity.common.Entity;
import cn.cat.entity.common.Page;



/**
 * 使用commons-dbutils.jar实现的通用DAO实现类
 * @author lorna
 * @param <T> 要操作的实体类类型，必须是Entity类的子类
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T extends Entity> implements BaseDao<T> {
	
	/**SQL执行器*/
	protected QueryRunner qr = new QueryRunner();
	
	/** 负责把结果集的第一行数据封装成一个JavaBean实例的结果集处理器 */
	protected BeanHandler<T> beanHandler; 
	
	/** 将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里的结果集处理器 */
	protected BeanListHandler<T> beanListHandler;
	
	/** 将结果集中某一条记录的其中某一列的数据存成 Object的结果集处理器 */
	protected ScalarHandler<Long> scalarHandler = new ScalarHandler<Long>();

	/**当前要操作的实体类的类型信息对象*/
	protected Class<T> clazz; 
	
	/**当前要操作的实体类对应的表的名称*/
	protected String tableName;
	
	/**
	 * 构造方法。会通过反射机制获取子类传递过来的实体类的类型信息，并自动以类名的全小写作为表名
	 */
	public BaseDaoImpl(){
		//通过反射机制获取子类传递过来的实体类的类型信息对象
		ParameterizedType type = (ParameterizedType)this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>)type.getActualTypeArguments()[0];
		
		beanHandler = new BeanHandler<T>(clazz);
		beanListHandler = new BeanListHandler<T>(clazz);
		
		//默认情况下，表名就是实体类名全部小写
		tableName = clazz.getSimpleName().toLowerCase();
	}
	
	/**
	 * 默认情况下，表名就是实体类名全部小写。如果需要更改表名，请在子类中重写本方法
	 */
	public String getTableName(){
		return tableName;
	}
	
	/**
	 * 默认情况下，表的主键列名是“id”
	 * @return
	 */
	public String getPkName(){
		return "id";
	}
	/* 根据时间排列*/
	public String getTime(){
		return "create_time";
	}
	@Override
	public T save(T entity) throws DaoException {
		
		//INSERT INTO 表名(列名,列名...) VALUES(?,?...);
		StringBuilder values = new StringBuilder("");
		StringBuilder sql = new StringBuilder("INSERT INTO ");
		sql.append(getTableName());
		sql.append("(");
		
		Map<String, Object> map = getFieldValueMap(entity);
		map.remove(getPkName()); //把主键列的值移除掉
		
		//用于存放参数值的集合
		List<Object> paramValues = new ArrayList<Object>();
		
		int i = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if(i++ > 0){
				sql.append(",");
				values.append(",");
			}
			String name = entry.getKey(); //字段名
			sql.append(name);
			
			values.append("?");
			Object value = entry.getValue(); //字段的值
			paramValues.add(value);
		}
		sql.append(") ");
		sql.append(" VALUES(");
		sql.append(values);
		sql.append(")");
		
		System.out.println(sql.toString());
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			Long temp = qr.insert(conn, sql.toString(), scalarHandler, paramValues.toArray());
			if(temp != null){
				entity.setId(temp);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return entity;
	}
	

	@Override
	public void update(T entity) throws DaoException {
		
		//UPDATE 表名 SET 列名=?,列名=?... WHERE id=?;
		StringBuilder sql = new StringBuilder("UPDATE ");
		sql.append(getTableName());
		sql.append(" SET ");
		
		Map<String, Object> map = getFieldValueMap(entity);
		//先获取主键列的值 
		Object idValue = map.get(getPkName());
		map.remove(getPkName()); //把主键列的值移除掉
		
		//用于存放参数值的集合
		List<Object> paramValues = new ArrayList<Object>();
		
		int i = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if(i++ > 0){
				sql.append(",");
			}
			String name = entry.getKey(); //字段名
			sql.append(name);
			sql.append("=?");
			
			Object value = entry.getValue(); //字段的值
			paramValues.add(value);
		}
		sql.append(" WHERE ");
		sql.append(getPkName());
		sql.append("=?");
		paramValues.add(idValue);
		
		System.out.println(sql.toString());
		System.out.println(paramValues);
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			qr.update(conn, sql.toString(), paramValues.toArray());
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		
		StringBuilder sql = new StringBuilder("DELETE FROM ");
		sql.append(getTableName());
		sql.append(" WHERE ");
		sql.append(getPkName());
		sql.append("=?");
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			qr.update(conn, sql.toString(), id);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}


	@Override
	public boolean exists(Long id) throws DaoException {
		boolean flag = false;
		
		StringBuilder sql = new StringBuilder("SELECT count(");
		sql.append(getPkName());
		sql.append(") FROM ");
		sql.append(getTableName());
		sql.append(" WHERE ");
		sql.append(getPkName());
		sql.append("=?");
		
		System.out.println(sql.toString());
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			Long temp = qr.query(conn, sql.toString(), scalarHandler, id);
			if(temp != null && temp.intValue() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
		return flag;
	}

	@Override
	public T findOne(Long id) throws DaoException {
		T entity = null;
		
		StringBuilder sql = new StringBuilder("SELECT * FROM ");
		sql.append(getTableName());
		sql.append(" WHERE ");
		sql.append(getPkName());
		sql.append("=?");
		
		System.out.println(sql.toString());
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			entity = qr.query(conn, sql.toString(), beanHandler, id);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
		return entity;
	}

	//浏览量
	public T findC(int count) throws DaoException {
		T entity = null;
		
		StringBuilder sql = new StringBuilder("SELECT * FROM ");
		sql.append(getTableName());
		sql.append(" WHERE ");
		sql.append(getHistory_click_times());
		sql.append("=?");
		
		System.out.println(sql.toString());
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			entity = qr.query(conn, sql.toString(), beanHandler, count);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
		return entity;
	}

	
	
	public String getHistory_click_times() {
		// TODO Auto-generated method stub
		return "history_click_times" ;
	}

	@Override
	public List<T> findAll() throws DaoException {
		List<T> list = null;
		
		StringBuilder sql = new StringBuilder("SELECT * FROM ");
		sql.append(getTableName());
		
		System.out.println(sql.toString());
		
		Connection conn = null;
		
		try{
			conn = DbHelper.getConn();
			list = qr.query(conn, sql.toString(), beanListHandler);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
		return list;
	}

	@Override
	public long count() throws DaoException {
		long count = 0; 
		
		StringBuilder sql = new StringBuilder("SELECT count(");
		sql.append(getPkName());
		sql.append(") FROM ");
		sql.append(getTableName());
		
		System.out.println(sql.toString());
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			Long temp = qr.query(conn, sql.toString(), scalarHandler);
			if(temp != null){
				count = temp.longValue();
			}
		}catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return count;
	}

	@Override
	public Page<T> findAll(int page, int size) throws DaoException {
		Page<T> pager = new Page<T>(page, size);
		
		long count = count();
		if(count > 0){
			pager.setTotalElements(count);
			
			StringBuilder sql = new StringBuilder("SELECT * FROM ");
			sql.append(getTableName());
			sql.append(" ORDER BY ");
			sql.append(getTime());
			sql.append(" DESC ");
			sql.append(" LIMIT ?,?");
			
			System.out.println(sql.toString());
			
			Object[] params = {(page - 1) * size, size};
			
			System.out.println(Arrays.toString(params));
			
			Connection conn = null;
			try{
				conn = DbHelper.getConn();
				List<T> items = qr.query(conn, sql.toString(), beanListHandler, params);
				pager.setItems(items);
			}catch (SQLException e) {
				throw new DaoException(e);
			}finally {
				DbUtils.closeQuietly(conn);
			}
		}
		
		return pager;
	}

	@Override
	public void update(String sql, Object... paramValues) throws DaoException {
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			
			qr.update(conn, sql, paramValues);
		}catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public List<T> find(String sql, Object... paramValues) throws DaoException {
		List<T> list = null;
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			
			list = qr.query(conn, sql, beanListHandler, paramValues);
		}catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return list;
	}
//模糊查询
	public List<T> finds(String sql, Object... paramValues) throws DaoException {
		List<T> list = null;
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			
			list = qr.query(conn, sql, beanListHandler, paramValues);
		}catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return list;
	}
	
	@Override
	public T findOne(String sql, Object... paramValues ) throws DaoException {
		T entity = null;
		
		Connection conn = null;
		try{
			conn = DbHelper.getConn();
			
			entity = qr.query(conn,sql, beanHandler, paramValues);
		}catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return entity;
	}

	/**
	 * 通过反射机制，获取指定实体类对象的所有属性名及对应值的Map实例
	 * @param entity 实例
	 * @return 字段名及对应值的Map实例
	 */
	protected Map<String, Object> getFieldValueMap(T entity){
		//key是属性名,value是对应值
		Map<String, Object> fieldValueMap = new HashMap<String, Object>();
		
		//获取当前加载的实体类中所有属性(字段)
		Field[] fields = this.clazz.getDeclaredFields(); //反射
		//获取父类中的属性
		Field[] parentFields = this.clazz.getSuperclass().getDeclaredFields();
		
		for(int i = 0; i < fields.length; i++){
			Field f = fields[i];
			String name = f.getName(); //属性名
			
			if(!"serialVersionUID".equalsIgnoreCase(name)){ //忽略序列化版本ID号
				//System.out.println("字段的名：" + name);
				
				f.setAccessible(true);//取消 Java语言访问检查
				try {
					Object value = f.get(entity); //反射获取该属性的值
					
					fieldValueMap.put(name, value);
					
					//System.out.println("字段值：" + value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(int i = 0; i < parentFields.length; i++){
			Field f = parentFields[i];
			String name = f.getName(); //属性名
			
			if(!"serialVersionUID".equalsIgnoreCase(name)){ //忽略序列化版本ID号
				//System.out.println("字段的名：" + name);
				
				f.setAccessible(true);//取消 Java语言访问检查
				try {
					Object value = f.get(entity); //反射获取该属性的值
					
					fieldValueMap.put(name, value);
					
					//System.out.println("字段值：" + value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return fieldValueMap;
	}

}
