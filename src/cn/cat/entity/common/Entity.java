package cn.cat.entity.common;

import java.io.Serializable;

/**
 * 所有实体类的基类，它主要是限定所有子类中都 应该有一个Long类型的名为“id”的属性，用来代表对应表的主键列。
 *
 */
public abstract class Entity implements Serializable{

	private static final long serialVersionUID = 7444501531032487969L;
	
	private Long id;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
		
	

	
}
