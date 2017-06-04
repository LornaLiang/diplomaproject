package cn.cat.entity;

import cn.cat.entity.common.Entity;

public class Comment extends Entity{

private Long blog_id;
private String content;
private String username;
private String email;
private String create_time;
private int agree_with_times;
public Long getBlog_id() {
	return blog_id;
}
public void setBlog_id(Long blog_id) {
	this.blog_id = blog_id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}
public int getAgree_with_times() {
	return agree_with_times;
}
public void setAgree_with_times(int agree_with_times) {
	this.agree_with_times = agree_with_times;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + agree_with_times;
	result = prime * result + ((blog_id == null) ? 0 : blog_id.hashCode());
	result = prime * result + ((content == null) ? 0 : content.hashCode());
	result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
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
	Comment other = (Comment) obj;
	if (agree_with_times != other.agree_with_times)
		return false;
	if (blog_id == null) {
		if (other.blog_id != null)
			return false;
	} else if (!blog_id.equals(other.blog_id))
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
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}
@Override
public String toString() {
	return "Comment [blog_id=" + blog_id + ", content=" + content + ", username=" + username + ", email=" + email
			+ ", create_time=" + create_time + ", agree_with_times=" + agree_with_times + "]";
}



}

