package cn.cat.dao.common;

import java.util.List;

import cn.cat.entity.common.Entity;
import cn.cat.entity.common.Page;
public interface BaseDao<T extends Entity> {

	/**
	 * 保存一个实例
	 * @param entity 要保存的实例 
	 */
	public T save(T entity) throws DaoException;
	
	/**
	 * 根据主键删除一个实例 
	 * @param id 主键值
	 */
	public void delete(Long id) throws DaoException;
	
	/**
	 * 编辑指定实例的详细信息
	 * @param entity 实例 
	 */
	public void update(T entity) throws DaoException;
	
	/**
	 * 判断指定主键对应的实体是否存在 
	 * @param id 主键值
	 * @return 存在返回true;否则返回false
	 */
	public boolean exists(Long id) throws DaoException;
	
	/**
	 * 根据主键获取对应的实例 
	 * @param id 主键值
	 * @return 如果查询成功，返回符合条件的实例;如果查询失败，返回null
	 */
	public T findOne(Long id) throws DaoException;
	
	/**
	 * 获取所有实体实例的列表
	 * @return 符合条件的实例列表
	 */
	public List<T> findAll() throws DaoException;
	
	/**
	 * 统计总实体实例的数量
	 * @return 总数量
	 */
	public long count() throws DaoException;
	
	
	/**
	 * 获取分页列表
	 * @param page 当前页号
	 * @param size 每页要显示的记录数
	 * @return 符合分页条件的分页模型实例
	 */
    public Page<T> findAll(int page, int size) throws DaoException;
	
	/**
	 * 根据指定的SQL语句和参数值执行更新数据的操作
	 * @param sql SQL语句
	 * @param paramValues 参数值数组
	 */
	public void update(String sql, Object... paramValues) throws DaoException;
	
	/**
	 * 根据指定的SQL语句和参数值执行查询数据的操作
	 * @param sql SQL语句
	 * @param paramValues 参数值
	 * @return 符合条件的实体对象列表
	 */
	public List<T> find(String sql, Object... paramValues) throws DaoException;
	
	/**
	 * 根据指定的SQL语句和参数值执行单个对象的查询操作
	 * @param sql SQL语句
	 * @param paramValues 参数值
	 * @return 符合条件的实体对象
	 */
	public T findOne(String sql, Object... paramValues) throws DaoException;
}
