package cn.hncu.bookStore.store.dao.factory;

import cn.hncu.bookStore.store.dao.Impl.StockDAOSerImpl;
import cn.hncu.bookStore.store.dao.dao.StockDAO;

public class StockDAOFactory {
	public static StockDAO getStockDAO(){
		return new StockDAOSerImpl();
	}
}
