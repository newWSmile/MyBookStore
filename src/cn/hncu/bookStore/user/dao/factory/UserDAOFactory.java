package cn.hncu.bookStore.user.dao.factory;

import cn.hncu.bookStore.user.dao.Impl.UserDAOSerImpl;
import cn.hncu.bookStore.user.dao.dao.UserDAO;

public class UserDAOFactory {
	public static UserDAO getUserDAO(){
		return new UserDAOSerImpl();
	}
}
