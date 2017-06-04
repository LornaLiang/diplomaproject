package cn.cat.entity.common;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 存放分页数据的模型类
 * @author qiujy
 * @param <T>
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 952170230768109488L;

	/** 当前页号 */
	private int number = 1;
	
	/** 每页要显示的记录条数 */
    private int size = 10; 
    
    /** 数据的总条数 */
    private long totalElements;
    
    /** 总页数,根据每页要显示的记录数和总记录数来计算得出 */
    private int totalPages;
    
    /** 存放当前页数据的集合 */
    private List<T> items = new ArrayList<T>();
    
    
    public Page(){}
    
	public Page(int number, int size) {
		super();
		this.number = number;
		this.size = size;
	}
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public long getTotalElements() {
		return totalElements;
	}
	
	
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
		
		if(totalElements % size == 0){
		    totalPages = (int)(totalElements / size);
		} else {
		    totalPages = (int)(totalElements / size) + 1;
		}
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	@SuppressWarnings("unused")
	private void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	
	
	@Override
	public String toString() {
		return "Page [number=" + number + ", size=" + size + ", totalElements=" + totalElements + ", totalPages="
				+ totalPages + "]";
	}
}
