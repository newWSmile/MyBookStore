package cn.hncu.bookStore.in.dao.factory;

import cn.hncu.bookStore.in.dao.Impl.InDetailDAOSerImpl;
import cn.hncu.bookStore.in.dao.dao.InDetailDAO;

public class InDetailDAOFactory {
	public static InDetailDAO getInDetailDAO(){
		return new InDetailDAOSerImpl();
	}
}	
