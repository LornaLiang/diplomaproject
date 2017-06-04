package cn.cat.dao.common;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class DaoFactory {
private static final Properties props = new Properties();
	
	private static final Map<String, Object> cache = Collections.synchronizedMap(new HashMap<String, Object>());
	
	private DaoFactory(){}
	
	static{
		try {
			props.load(Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("dao.properties"));
		} catch (IOException e) {
			System.err.println("在classpath下未找到dao.properties配置文件！！！");
			e.printStackTrace();
		} 
	}
	
	
	/**
     * 根据传递的dao名称创建出它的实现类的实例
     * @param daoName 在dao.properties文件中配置的dao名
     * @return 成功,返回实现类的实例; 否则,返回null
     */
	public static Object getInstance(String daoName) throws DaoException{
		Object obj = null;
		
		obj = cache.get(daoName);
		if(obj == null){
			
			String className = props.getProperty(daoName);
			if(className == null || "".equals(className)){
				throw new DaoException("指定的DAO实现类全限定名在dao.properties中未找到！");
			}
			
			try {
				obj = Class.forName(className).newInstance();
				
				cache.put(daoName, obj);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				throw new DaoException("加载指定DAO实现类的字节出现异常", e);
			}
		}
		
		return obj;
	}
}
