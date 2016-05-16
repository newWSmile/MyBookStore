package cn.hncu.bookStore.store.dao.dao;

import java.util.List;

import cn.hncu.bookStore.store.vo.StockModel;
import cn.hncu.bookStore.store.vo.StockQueryModel;

public interface StockDAO {
	public boolean addStock(StockModel stock);
	public boolean updateStock(StockModel stock);
	
	public StockModel getSingle(String uuid);
	public List<StockModel> getAll();
	public List<StockModel> getByCondition(StockQueryModel sqm);
	
	
}
