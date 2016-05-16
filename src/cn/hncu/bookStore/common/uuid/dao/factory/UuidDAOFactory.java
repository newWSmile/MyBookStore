package cn.hncu.bookStore.common.uuid.dao.factory;

import cn.hncu.bookStore.common.uuid.dao.Impl.UuidDAOSerImpl;
import cn.hncu.bookStore.common.uuid.dao.dao.UuidDAO;

public class UuidDAOFactory {
	public static UuidDAO getUuidDAO(){
		return new UuidDAOSerImpl();
	}
}
