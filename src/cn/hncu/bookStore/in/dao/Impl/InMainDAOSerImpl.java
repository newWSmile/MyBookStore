package cn.hncu.bookStore.in.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.in.dao.dao.InMainDAO;
import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.in.vo.InMainQueryModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class InMainDAOSerImpl implements InMainDAO{
	private final String FILE_NAME="InMain.txt";
	@Override
	public boolean addInMain(InMainModel inMain) {
		//1反序列化
		List<InMainModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2遍历
		for(InMainModel in:list){
			if(in.getUuid().equals(inMain.getUuid())){
				return false;
			}
		}
		list.add(inMain);
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean deleteInMain(String uuid) {
		//1反序列化
		List<InMainModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(InMainModel in:list){
			if(in.getUuid().equals(uuid)){
				list.remove(in);
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean updateInMain(InMainModel inMain) {
		//1反序列化
		List<InMainModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(int i=0;i<list.size();i++){
			InMainModel in =list.get(i);
			if(in.getUuid().equals(inMain.getUuid())){
				list.set(i, in);
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	@Override
	public InMainModel getSingle(String uuid) {
		//1反序列化
		List<InMainModel> list=FileIoUtil.readFromFile(FILE_NAME);
		for(InMainModel in:list){
			if(in.getUuid().equals(uuid)){
				return in;
			}
		}
		return null;
	}

	@Override
	public List<InMainModel> getAll() {
		List<InMainModel> list=FileIoUtil.readFromFile(FILE_NAME);
		return list;
	}

	@Override
	public List<InMainModel> getByCondition(InMainQueryModel imqm) {
		List<InMainModel> list=getAll();
		List<InMainModel> results=new ArrayList<InMainModel>();
		for(InMainModel inMain:list){
			if(imqm.getUuid()!=null && imqm.getUuid().trim().length()>0){
				if(!imqm.getUuid().equals(inMain.getUuid()) ){
					continue;
				}
			}
			if(imqm.getInUserId()!=null && imqm.getInUserId().trim().length()>0){
				if(! imqm.getInUserId().equals(inMain.getInUserId())){
					continue;
				}
			}
			if(imqm.getInDate()>0){
				if(inMain.getInDate()<imqm.getInDate()){
					continue;
				}
			}
			if(imqm.getInDate2()>0){
				if(inMain.getInDate()>imqm.getInDate2()){
					continue;
				}
			}
			results.add(inMain);
		}
		
		return results;
	}

}
