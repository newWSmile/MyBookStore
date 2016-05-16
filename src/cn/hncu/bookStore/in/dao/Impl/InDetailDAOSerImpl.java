package cn.hncu.bookStore.in.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.in.dao.dao.InDetailDAO;
import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class InDetailDAOSerImpl implements InDetailDAO{
	private final String FILE_NAME="InDetail.txt";
	@Override
	public boolean addInDetail(InDetailModel inDetail) {
		List<InDetailModel> list =FileIoUtil.readFromFile(FILE_NAME);
		for(InDetailModel model:list){
			if(model.getUuid().equals(inDetail.getUuid())){//存在，则不能添加
				return false;
			}
		}
		list.add(inDetail);
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean deleteInMain(String uuid) {
		List<InDetailModel> list = FileIoUtil.readFromFile(FILE_NAME);
		for(InDetailModel model:list){
			if(model.getUuid().equals(uuid)){//存在，则删除
				list.remove(model);
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateInMain(InDetailModel inDetail) {
		List<InDetailModel> list = FileIoUtil.readFromFile(FILE_NAME);
		for(int i=0;i<list.size();i++){
			InDetailModel model = list.get(i);
			if(model.getUuid().equals(inDetail.getUuid())){//存在，则删除
				list.set(i, inDetail);
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public InDetailModel getSingle(String uuid) {
		List<InDetailModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(InDetailModel model: list){
			if(model.getUuid().equals(uuid)){
				return  model;
			}
		}
		return null;
	}

	@Override
	public List<InDetailModel> getAll() {
		return FileIoUtil.readFromFile(FILE_NAME);
	}

	@Override
	public List<InDetailModel> getByCondition(InDetailQueryModel idqm) {
		List<InDetailModel> list= getAll();
		List<InDetailModel> results=new ArrayList<InDetailModel>();
		for(InDetailModel model:list){
			if(idqm.getUuid()!=null && idqm.getUuid().trim().length()>0){
				if(!idqm.getUuid().equals(model.getUuid())){
					continue;
				}
			}
			if(idqm.getInId()!=null && idqm.getInId().trim().length()>0){
				if(!idqm.getInId().equals(model.getInId())){
					continue;
				}
			}
			if(idqm.getBookId()!=null && idqm.getBookId().trim().length()>0){
				if(!idqm.getBookId().equals(model.getBookId())){
					continue;
				}
			}
			if(idqm.getSumNum()>0){
				if(idqm.getSumNum()>model.getSumNum()){
					continue;
				}
			}
			if(idqm.getSumNum2()>0){
				if(idqm.getSumNum2()<model.getSumNum()){
					continue;
				}
			}
			if(idqm.getSumMoney()>0){
				if(idqm.getSumMoney()>model.getSumMoney()){
					continue;
				}
			}
			if(idqm.getSumMoney2()>0){
				if(idqm.getSumMoney2()<model.getSumMoney()){
					continue;
				}
			}
			results.add(model);
		}
		return results;
	}

}
