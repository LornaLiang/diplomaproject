package cn.cat.entity;


import java.sql.Timestamp;

import cn.cat.entity.common.Entity;

public class Blog extends Entity {

private String title;
private String content;
private String type;
private int click_times;
private String create_time;
private int comment_times;
private int agree_with_times;
private String pic_url;
private String photoname;

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String cintent) {
	this.content = cintent;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getClick_times() {
	return click_times;
}
public void setClick_times(int click_times) {
	this.click_times = click_times;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}
public int getComment_times() {
	return comment_times;
}
public void setComment_times(int comment_times) {
	this.comment_times = comment_times;
}
public int getAgree_with_times() {
	return agree_with_times;
}
public void setAgree_with_times(int agree_with_times) {
	this.agree_with_times = agree_with_times;
}
public String getPic_url() {
	return pic_url;
}
public void setPic_url(String pic_url) {
	this.pic_url = pic_url;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + agree_with_times;
	result = prime * result + click_times;
	result = prime * result + comment_times;
	result = prime * result + ((content == null) ? 0 : content.hashCode());
	result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
	result = prime * result + ((photoname == null) ? 0 : photoname.hashCode());
	result = prime * result + ((pic_url == null) ? 0 : pic_url.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
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
	Blog other = (Blog) obj;
	if (agree_with_times != other.agree_with_times)
		return false;
	if (click_times != other.click_times)
		return false;
	if (comment_times != other.comment_times)
		return false;
	if (content == null) {
		if (other.content != null)
			return false;
	} else if (!content.equals(other.content))
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
	if (pic_url == null) {
		if (other.pic_url != null)
			return false;
	} else if (!pic_url.equals(other.pic_url))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	return true;
}
@Override
public String toString() {
	return "Blog [title=" + title + ", content=" + content + ", type=" + type + ", click_times=" + click_times
			+ ", create_time=" + create_time + ", comment_times=" + comment_times + ", agree_with_times="
			+ agree_with_times + ", pic_url=" + pic_url + ", photoname=" + photoname + "]";
}
public String getPhotoname() {
	return photoname;
}
public void setPhotoname(String photoname) {
	this.photoname = photoname;
}




}
