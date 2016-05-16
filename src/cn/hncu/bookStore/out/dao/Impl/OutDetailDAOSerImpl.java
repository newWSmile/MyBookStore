package cn.hncu.bookStore.out.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.out.dao.dao.OutDetailDAO;
import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.bookStore.out.vo.OutMainModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class OutDetailDAOSerImpl implements OutDetailDAO{
	private final String FILE_NAME="OutDetail.txt";
	@Override
	public boolean addOutDetail(OutDetailModel outDetail) {
		List<OutDetailModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(OutDetailModel model:list){
			if(outDetail.getUuid().equals(model.getUuid())){
				return false;
			}
		}
		list.add(outDetail);
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
		
	}

	@Override
	public boolean deleteOutDetail(String uuid) {
		List<OutDetailModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(OutDetailModel model:list){
			if(model.getUuid().equals(uuid)){
				list.remove(model);
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateOutDetail(OutDetailModel outDetail) {
		List<OutDetailModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(OutDetailModel model:list){
			if(model.getUuid().equals(outDetail.getUuid())){
				model=outDetail;
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public OutDetailModel getSingle(String uuid) {
		List<OutDetailModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(OutDetailModel model:list){
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}

	@Override
	public List<OutDetailModel> getAll() {
		return FileIoUtil.readFromFile(FILE_NAME);
	}

	@Override
	public List<OutDetailModel> getByCondition(OutDetailQueryModel odqm) {
		List<OutDetailModel> list=getAll();
		List<OutDetailModel> results=new ArrayList<OutDetailModel>();
		for(OutDetailModel model:list){
			if(odqm.getUuid()!=null && odqm.getUuid().trim().length()>0){
				if(!model.getUuid().equals(odqm.getUuid())){
					continue;
				}
			}
			if(odqm.getOutId()!=null && odqm.getOutId().trim().length()>0){
				if(!model.getOutId().equals(odqm.getOutId())){
					continue;
				}
			}
			if(odqm.getBookUuid()!=null && odqm.getBookUuid().trim().length()>0){
				if(!model.getBookUuid().equals(odqm.getBookUuid())){
					continue;
				}
			}
			if(odqm.getSumNum()>0){
				if(model.getSumNum()<odqm.getSumNum()){
					continue;
				}
			}
			if(odqm.getSumNum2()>0){
				if(model.getSumNum()>odqm.getSumNum2()){
					continue;
				}
			}
			
			if(odqm.getSumMoney()>0){
				if(model.getSumMoney()<odqm.getSumMoney()){
					continue;
				}
			}
			if(odqm.getSumMoney2()>0){
				if(model.getSumMoney()>odqm.getSumMoney2()){
					continue;
				}
			}
			results.add(model);
		}
		return results;
	}

}
