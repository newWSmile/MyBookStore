package cn.hncu.bookStore.out.vo;

import java.io.Serializable;

import cn.hncu.bookStore.utils.DateUtil;

public class OutMainModel implements Serializable,Comparable<OutMainModel>{
	private String uuid;
	private long outDate;
	private String outUserUuid;
	
	//给用户看的字段
	private String outUserName;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public long getOutDate() {
		return outDate;
	}

	public void setOutDate(long outDate) {
		this.outDate = outDate;
	}

	public String getOutUserUuid() {
		return outUserUuid;
	}

	public void setOutUserUuid(String outUserUuid) {
		this.outUserUuid = outUserUuid;
	}

	public String getOutUserName() {
		return outUserName;
	}

	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName;
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
		OutMainModel other = (OutMainModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  uuid + " ," + outUserName+", "+DateUtil.long2String(outDate);
	}

	@Override
	public int compareTo(OutMainModel o) {
		
		return Integer.parseInt(uuid)-Integer.parseInt(o.getUuid());
	}
	
}
