package cn.hncu.bookStore.out.dao.Impl;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.out.dao.dao.OutMainDAO;
import cn.hncu.bookStore.out.vo.OutMainModel;
import cn.hncu.bookStore.out.vo.OutMainQueryModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class OutMainDAOSerImpl implements OutMainDAO{
	private final String FILE_NAME="OutMain.txt";
	@Override
	public boolean addOutMain(OutMainModel outMain) {
		List<OutMainModel>list=FileIoUtil.readFromFile(FILE_NAME);
		for(OutMainModel model:list){
			if(outMain.getUuid().equals(model.getUuid())){
				return false;
			}
		}
		list.add(outMain);
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean deleteOutMain(String uuid) {
		List<OutMainModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(OutMainModel model:list){
			if(model.getUuid().equals(uuid)){
				list.remove(model);
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateOutMain(OutMainModel outMain) {
		List<OutMainModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(OutMainModel model:list){
			if(model.getUuid().equals(outMain.getUuid())){
				model=outMain;
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public OutMainModel getSingle(String uuid) {
		List<OutMainModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(OutMainModel model:list){
			if(model.getUuid().equals(uuid)){
				return model;
			}
		}
		return null;
	}

	@Override
	public List<OutMainModel> getAll() {
		return FileIoUtil.readFromFile(FILE_NAME);
	}

	@Override
	public List<OutMainModel> getByCondition(OutMainQueryModel omqm) {
		List<OutMainModel> list=getAll();
		List<OutMainModel> results=new ArrayList<OutMainModel>();
		for(OutMainModel outMain:list){
			if(omqm.getUuid()!=null && omqm.getUuid().trim().length()>0){
				if(!omqm.getUuid().equals(outMain.getUuid())){
					continue;
				}
			}
			if(omqm.getOutUserUuid()!=null && omqm.getOutUserUuid().trim().length()>0){
				if(!omqm.getOutUserUuid().equals(outMain.getOutUserUuid())){
					continue;
				}
			}
			
			if(omqm.getOutDate()>0){
				if(outMain.getOutDate()<omqm.getOutDate()){
					continue;
				}
			}
			if(omqm.getOutDate2()>0){
				if(outMain.getOutDate()>omqm.getOutDate2()){
					continue;
				}
			}
			results.add(outMain);
		}
		return results;
	}
	
	
}
