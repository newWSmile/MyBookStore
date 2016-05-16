package cn.hncu.bookStore.common;

public enum UserTypeEnum {
	ADMIN(1,"超级管理员"),
	BOOK(2,"图书管理员"),
	IN(3,"进货管理员"),
	OUT(4,"销售管理员"),
	STOCK(5,"库存管理员");
	
	private final int type;
	private final String name;
	private UserTypeEnum(int type, String name){
		this.type = type;
		this.name = name;
	}
	
	public int getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	
	public static String getNameByType( int type){
		for( UserTypeEnum userType:UserTypeEnum.values()){
			if(userType.getType()==type){
				return userType.getName();
			}
		}
		throw new IllegalArgumentException("枚举中没有对应的用户类型:"+type);
	}
	
	public static int getTypeByName( String name){
		for(UserTypeEnum userType: UserTypeEnum.values()){
			if(userType.getName().equals(name)){
				return userType.getType();
			}
		}
		throw new IllegalArgumentException("枚举中没有对应的用户类型:"+name);
	}
	
	public static void main(String[] args) {
		System.out.println( getNameByType(3) );
		//System.out.println( getNameByType(0) );//测试抛异常能力
		System.out.println( getTypeByName("超级管理员") );
		//System.out.println( getTypeByName("管理员") ); //测试抛异常能力
	}
	
}
