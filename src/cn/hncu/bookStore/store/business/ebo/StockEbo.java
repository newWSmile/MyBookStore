package cn.hncu.bookStore.store.business.ebo;

import java.util.List;

import cn.hncu.bookStore.store.business.ebi.StockEbi;
import cn.hncu.bookStore.store.dao.factory.StockDAOFactory;
import cn.hncu.bookStore.store.vo.StockModel;
import cn.hncu.bookStore.store.vo.StockQueryModel;

public class StockEbo implements StockEbi{

	@Override
	public List<StockModel> getAll() {
		List<StockModel> list=StockDAOFactory.getStockDAO().getAll();
		return list;
	}

	@Override
	public List<StockModel> getByCondition(StockQueryModel sqm) {
		return StockDAOFactory.getStockDAO().getByCondition(sqm);
	}

}
