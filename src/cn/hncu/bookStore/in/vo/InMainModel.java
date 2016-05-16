package cn.hncu.bookStore.in.vo;

import java.io.Serializable;

import cn.hncu.bookStore.utils.DateUtil;

public class InMainModel implements Serializable,Comparable<InMainModel>{
	private String uuid;//进货编号
	private String inUserId;//进货管理员的编号
	private long inDate;//时间
	
	//给用户看的字段
	private String inUserName;
	
	public String getInUserName() {
		return inUserName;
	}
	public void setInUserName(String inUserName) {
		this.inUserName = inUserName;
	}
	public InMainModel() {
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getInUserId() {
		return inUserId;
	}
	public void setInUserId(String inUserId) {
		this.inUserId = inUserId;
	}
	public long getInDate() {
		return inDate;
	}
	public void setInDate(long inDate) {
		this.inDate = inDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		InMainModel other = (InMainModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  uuid + ", " + inUserName
				+ ", " + DateUtil.long2String(inDate) ;
	}
	@Override
	public int compareTo(InMainModel o) {
		return Integer.parseInt(uuid)-Integer.parseInt(o.getUuid());
	}
	
	
}
