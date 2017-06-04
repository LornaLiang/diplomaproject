package cn.cat.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.ws.handler.Handler;

import cn.cat.entity.common.Entity;

public class Info extends Entity {

private int today_click_times;
private int history_click_times;

public int getToday_click_times() {
	return today_click_times;
}
public void setToday_click_times(int today_click_times) {
	this.today_click_times = today_click_times;
}
public int getHistory_click_times() {
	return history_click_times;
}
public void setHistory_click_times(int history_click_times) {
	this.history_click_times = history_click_times;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + history_click_times;
	
	result = prime * result + today_click_times;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Info other = (Info) obj;
	if (history_click_times != other.history_click_times)
		return false;
	
	if (today_click_times != other.today_click_times)
		return false;
	return true;
}
@Override
public String toString() {
	return "Info [today_click_times=" + today_click_times + ", history_click_times="
			+ history_click_times + "]";
}


 }



