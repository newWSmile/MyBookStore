package cn.hncu.bookStore.store.vo;

import java.io.Serializable;

public class StockModel implements Serializable{
	private String uuid;
	private String bookUuid;
	private int sumNum;
	
	private String bookName;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
		StockModel other = (StockModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ø‚¥Ê±‡∫≈£∫" + uuid + ",  È√˚£∫°∂" + bookName + "°∑£¨ "+ sumNum+"±æ";
	}
	
	
	
}
