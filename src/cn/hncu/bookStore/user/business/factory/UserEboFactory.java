package cn.hncu.bookStore.user.business.factory;

import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.ebo.UserEbo;

public class UserEboFactory {
	public static UserEbi getUserEbi(){
		return new UserEbo();
	}
}
