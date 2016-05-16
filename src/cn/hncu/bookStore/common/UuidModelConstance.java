package cn.hncu.bookStore.common;

public enum UuidModelConstance {
	USER("UserModel"),
	BOOK("BookModel"),
	IN_Main("InMainModel"),
	In_Detail("InDetailModel"),
	OUT_Main("OutMainModel"),
	OUT_Detail("OutDetailModel"),
	STACK("StackModel");
	private final String name;
	private UuidModelConstance(String name){
		this.name=name;
		
	}
	public String getModelName() {
		return name;
	}

	
	
}
