package cn.hncu.bookStore.common.login.business.factory;

import cn.hncu.bookStore.common.login.business.ebi.LoginEbi;
import cn.hncu.bookStore.common.login.business.ebo.LoginEbo;

public class LoginEbiFactory {
	public static LoginEbi getLoginEbi(){
		return new LoginEbo();
	}
}
