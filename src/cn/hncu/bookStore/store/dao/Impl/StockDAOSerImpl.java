package cn.hncu.bookStore.store.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.store.dao.dao.StockDAO;
import cn.hncu.bookStore.store.vo.StockModel;
import cn.hncu.bookStore.store.vo.StockQueryModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class StockDAOSerImpl implements StockDAO{
	private final String FILE_NAME="Stock.txt";
	@Override
	public boolean addStock(StockModel stock) {
		List<StockModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(StockModel model : list){
			if(model.getUuid().equals(stock.getUuid())){
				return false;
			}
		}
		list.add(stock);
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean updateStock(StockModel stock) {
		List<StockModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(int i=0;i<list.size();i++){
			StockModel model = list.get(i);
			if(model.getUuid().equals(stock.getUuid())){
				list.set(i, stock);
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public StockModel getSingle(String uuid) {
		List<StockModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(StockModel model : list){
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}

	@Override
	public List<StockModel> getAll() {
		return FileIoUtil.readFromFile(FILE_NAME);
	}

	@Override
	public List<StockModel> getByCondition(StockQueryModel sqm) {
		List<StockModel> list= FileIoUtil.readFromFile(FILE_NAME);
		List<StockModel> results= new ArrayList<StockModel>();
		for(StockModel model:list){
			if(sqm.getUuid()!=null && sqm.getUuid().trim().length()>0){
				if(! sqm.getUuid().equals(model.getUuid())){
					continue;
				}
			}
			if(sqm.getBookUuid()!=null && sqm.getBookUuid().trim().length()>0){
				if(! sqm.getBookUuid().equals(model.getBookUuid())){
					continue;
				}
			}
			if(sqm.getSumNum()>0){
				if(model.getSumNum()<sqm.getSumNum()){
					continue;
				}
			}
			if(sqm.getSumNum2()>0){
				if(model.getSumNum()>sqm.getSumNum2()){
					continue;
				}
			}
			results.add(model);
		}
		return results;
	}

}
