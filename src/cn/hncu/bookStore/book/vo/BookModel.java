package cn.hncu.bookStore.book.vo;

import java.io.Serializable;

public class BookModel implements Serializable{
	private String uuid;
	private String name;
	private double inPrice;
	private double salePrice;
	public BookModel() {
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String boid) {
		this.uuid = boid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
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
		BookModel other = (BookModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return uuid + "," + name + ", inPrice="
				+ inPrice + ", salePrice=" + salePrice;
	}
	
}
