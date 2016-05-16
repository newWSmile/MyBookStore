package cn.hncu.bookStore.out.vo;

import java.io.Serializable;

public class OutDetailModel implements Serializable{
	private String uuid;
	private String outId;
	private String bookUuid;
	private int sumNum;
	private double sumMoney;
	//显示给用户看的
	private String bookName;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getOutId() {
		return outId;
	}
	public void setOutId(String outId) {
		this.outId = outId;
	}
	public String getBookUuid() {
		return bookUuid;
	}
	public void setBookUuid(String bookUuid) {
		this.bookUuid = bookUuid;
	}
	public int getSumNum() {
		return sumNum;
	}
	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}
	public double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
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
		OutDetailModel other = (OutDetailModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  uuid + ", 销售单号:" + outId+", 《" + bookName + "》"
				+ ", 数量:" + sumNum + "本, 总价=" + sumMoney+ "元";
	}
	
	
	
}
