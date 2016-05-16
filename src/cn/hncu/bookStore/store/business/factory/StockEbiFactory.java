package cn.hncu.bookStore.store.business.factory;

import cn.hncu.bookStore.store.business.ebi.StockEbi;
import cn.hncu.bookStore.store.business.ebo.StockEbo;

public class StockEbiFactory {
	public static StockEbi getStockEbi(){
		return new StockEbo();
	}
}
