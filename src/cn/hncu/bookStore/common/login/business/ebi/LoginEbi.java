package cn.hncu.bookStore.common.login.business.ebi;

public interface LoginEbi {
	/**
	 * 功能：用来判断输入的用户名和密码与数据库中的数据是否匹配
	 * 
	 * @param userName 用户名
	 * @param pwd 对应用户的密码
	 * 
	 * @return 如果匹配则返回null；
	 * 			不匹配就返回对应的错误信息：不存在此用户、输入的密码不正确
	 */
	public String login(String userName,String pwd);
}
