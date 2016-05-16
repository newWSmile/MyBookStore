package cn.hncu.bookStore.out.dao.factory;

import cn.hncu.bookStore.out.dao.Impl.OutMainDAOSerImpl;
import cn.hncu.bookStore.out.dao.dao.OutMainDAO;

public class OutMainDAOFactory {
	public static OutMainDAO getOutMainDAO(){
		return new OutMainDAOSerImpl();
	}
}
