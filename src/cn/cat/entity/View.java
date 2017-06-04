package cn.cat.entity;

import cn.cat.entity.common.Entity;

public class View extends Entity {
	private Long blo_id;
	private String blo_type;
	private String blo_title;
	private String blo_content;
	private String blo_create_time;
	private int blo_click_times;
	private int blo_comment_times;
	private Long comm_id;
	private String comm_username;
	private String comm_email;
	private String comm_create_times;
	private int t_id;
	public Long getBlo_id() {
		return blo_id;
	}
	public void setBlo_id(Long blo_id) {
		this.blo_id = blo_id;
	}
	public String getBlo_type() {
		return blo_type;
	}
	public void setBlo_type(String blo_type) {
		this.blo_type = blo_type;
	}
	public String getBlo_title() {
		return blo_title;
	}
	public void setBlo_title(String blo_title) {
		this.blo_title = blo_title;
	}
	public String getBlo_content() {
		return blo_content;
	}
	public void setBlo_content(String blo_content) {
		this.blo_content = blo_content;
	}
	public String getBlo_create_time() {
		return blo_create_time;
	}
	public void setBlo_create_time(String blo_create_time) {
		this.blo_create_time = blo_create_time;
	}
	public int getBlo_click_times() {
		return blo_click_times;
	}
	public void setBlo_click_times(int blo_click_times) {
		this.blo_click_times = blo_click_times;
	}
	public int getBlo_comment_times() {
		return blo_comment_times;
	}
	public void setBlo_comment_times(int blo_comment_times) {
		this.blo_comment_times = blo_comment_times;
	}
	public Long getComm_id() {
		return comm_id;
	}
	public void setComm_id(Long comm_id) {
		this.comm_id = comm_id;
	}
	public String getComm_username() {
		return comm_username;
	}
	public void setComm_username(String comm_username) {
		this.comm_username = comm_username;
	}
	public String getComm_email() {
		return comm_email;
	}
	public void setComm_email(String comm_email) {
		this.comm_email = comm_email;
	}
	public String getComm_create_times() {
		return comm_create_times;
	}
	public void setComm_create_times(String comm_create_times) {
		this.comm_create_times = comm_create_times;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blo_click_times;
		result = prime * result + blo_comment_times;
		result = prime * result + ((blo_content == null) ? 0 : blo_content.hashCode());
		result = prime * result + ((blo_create_time == null) ? 0 : blo_create_time.hashCode());
		result = prime * result + ((blo_id == null) ? 0 : blo_id.hashCode());
		result = prime * result + ((blo_title == null) ? 0 : blo_title.hashCode());
		result = prime * result + ((blo_type == null) ? 0 : blo_type.hashCode());
		result = prime * result + ((comm_create_times == null) ? 0 : comm_create_times.hashCode());
		result = prime * result + ((comm_email == null) ? 0 : comm_email.hashCode());
		result = prime * result + ((comm_id == null) ? 0 : comm_id.hashCode());
		result = prime * result + ((comm_username == null) ? 0 : comm_username.hashCode());
		result = prime * result + t_id;
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
		View other = (View) obj;
		if (blo_click_times != other.blo_click_times)
			return false;
		if (blo_comment_times != other.blo_comment_times)
			return false;
		if (blo_content == null) {
			if (other.blo_content != null)
				return false;
		} else if (!blo_content.equals(other.blo_content))
			return false;
		if (blo_create_time == null) {
			if (other.blo_create_time != null)
				return false;
		} else if (!blo_create_time.equals(other.blo_create_time))
			return false;
		if (blo_id == null) {
			if (other.blo_id != null)
				return false;
		} else if (!blo_id.equals(other.blo_id))
			return false;
		if (blo_title == null) {
			if (other.blo_title != null)
				return false;
		} else if (!blo_title.equals(other.blo_title))
			return false;
		if (blo_type == null) {
			if (other.blo_type != null)
				return false;
		} else if (!blo_type.equals(other.blo_type))
			return false;
		if (comm_create_times == null) {
			if (other.comm_create_times != null)
				return false;
		} else if (!comm_create_times.equals(other.comm_create_times))
			return false;
		if (comm_email == null) {
			if (other.comm_email != null)
				return false;
		} else if (!comm_email.equals(other.comm_email))
			return false;
		if (comm_id == null) {
			if (other.comm_id != null)
				return false;
		} else if (!comm_id.equals(other.comm_id))
			return false;
		if (comm_username == null) {
			if (other.comm_username != null)
				return false;
		} else if (!comm_username.equals(other.comm_username))
			return false;
		if (t_id != other.t_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "View [blo_id=" + blo_id + ", blo_type=" + blo_type + ", blo_title=" + blo_title + ", blo_content="
				+ blo_content + ", blo_create_time=" + blo_create_time + ", blo_click_times=" + blo_click_times
				+ ", blo_comment_times=" + blo_comment_times + ", comm_id=" + comm_id + ", comm_username="
				+ comm_username + ", comm_email=" + comm_email + ", comm_create_times=" + comm_create_times + ", t_id="
				+ t_id + "]";
	}
	
	

}
