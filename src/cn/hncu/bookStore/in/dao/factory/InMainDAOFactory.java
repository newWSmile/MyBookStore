package cn.hncu.bookStore.in.dao.factory;

import cn.hncu.bookStore.in.dao.Impl.InMainDAOSerImpl;
import cn.hncu.bookStore.in.dao.dao.InMainDAO;

public class InMainDAOFactory {
	public static InMainDAO getInMainDAO(){
		return new InMainDAOSerImpl();
	}
}
