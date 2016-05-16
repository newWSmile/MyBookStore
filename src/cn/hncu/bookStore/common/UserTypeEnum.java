package cn.hncu.bookStore.common;

public enum UserTypeEnum {
	ADMIN(1,"��������Ա"),
	BOOK(2,"ͼ�����Ա"),
	IN(3,"��������Ա"),
	OUT(4,"���۹���Ա"),
	STOCK(5,"������Ա");
	
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
		throw new IllegalArgumentException("ö����û�ж�Ӧ���û�����:"+type);
	}
	
	public static int getTypeByName( String name){
		for(UserTypeEnum userType: UserTypeEnum.values()){
			if(userType.getName().equals(name)){
				return userType.getType();
			}
		}
		throw new IllegalArgumentException("ö����û�ж�Ӧ���û�����:"+name);
	}
	
	public static void main(String[] args) {
		System.out.println( getNameByType(3) );
		//System.out.println( getNameByType(0) );//�������쳣����
		System.out.println( getTypeByName("��������Ա") );
		//System.out.println( getTypeByName("����Ա") ); //�������쳣����
	}
	
}
