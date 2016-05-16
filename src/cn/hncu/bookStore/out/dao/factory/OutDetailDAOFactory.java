package cn.hncu.bookStore.out.dao.factory;

import cn.hncu.bookStore.out.dao.Impl.OutDetailDAOSerImpl;
import cn.hncu.bookStore.out.dao.dao.OutDetailDAO;

public class OutDetailDAOFactory {
	public static OutDetailDAO getOutDetailDAO(){
		return new OutDetailDAOSerImpl();
	}
}
