package cn.cat.entity;



import java.sql.Date;
import java.sql.Timestamp;

import cn.cat.entity.common.Entity;

public class Album extends Entity {

private  String url;
private String title;
private  String create_time;
private int agree_with_times;
private String photoname;

public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + agree_with_times;
	result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
	result = prime * result + ((photoname == null) ? 0 : photoname.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	result = prime * result + ((url == null) ? 0 : url.hashCode());
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
	Album other = (Album) obj;
	if (agree_with_times != other.agree_with_times)
		return false;
	if (create_time == null) {
		if (other.create_time != null)
			return false;
	} else if (!create_time.equals(other.create_time))
		return false;
	if (photoname == null) {
		if (other.photoname != null)
			return false;
	} else if (!photoname.equals(other.photoname))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	if (url == null) {
		if (other.url != null)
			return false;
	} else if (!url.equals(other.url))
		return false;
	return true;
}
@Override
public String toString() {
	return "Album [url=" + url + ", title=" + title + ", create_time=" + create_time + ", agree_with_times="
			+ agree_with_times + ", photoname=" + photoname + "]";
}
public int getAgree_with_times() {
	return agree_with_times;
}
public void setAgree_with_times(int agree_with_times) {
	this.agree_with_times = agree_with_times;
}
public String getPhotoname() {
	return photoname;
}
public void setPhotoname(String photoname) {
	this.photoname = photoname;
}

}
