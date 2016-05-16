package cn.hncu.bookStore.store.business.ebi;

import java.util.List;

import cn.hncu.bookStore.store.vo.StockModel;
import cn.hncu.bookStore.store.vo.StockQueryModel;

public interface StockEbi {
	public List<StockModel> getAll();
	public List<StockModel> getByCondition(StockQueryModel sqm);
}
