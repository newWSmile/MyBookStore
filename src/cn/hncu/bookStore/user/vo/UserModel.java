package cn.hncu.bookStore.user.vo;

import java.io.Serializable;

import cn.hncu.bookStore.common.UserTypeEnum;
/**
 * 
 * @author <a href="mailto:wyj950411@foxmail.com">军街</a>
 * @version 1.0 2016-4-5
 * <br/>
 * 用于封装数据的值对象<br/>
 * 1，可序列化 implements Serializable接口<br/>
 * 2,变量私有化<br/>
 * 3,写空参构造函数<br/>
 * 4,hashCode和equals方法<br/>
 * 5,setter-getters方法；
 * 
 */
public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String name;
	private int type;
	private String pwd;
	public UserModel() {
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return uuid + "," + name + "," + UserTypeEnum.getNameByType(type);
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
		UserModel other = (UserModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	
}
