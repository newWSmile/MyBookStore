package cn.hncu.bookStore.common.uuid.dao.Impl;

import java.util.List;

import cn.hncu.bookStore.common.UuidModelConstance;
import cn.hncu.bookStore.common.uuid.dao.dao.UuidDAO;
import cn.hncu.bookStore.common.uuid.vo.UuidModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class UuidDAOSerImpl implements UuidDAO{
	private final String FILE_NAME="Uuid.txt";
	@Override
	public String getNextUuid(UuidModelConstance uuidEnum) {
		//1
		List<UuidModel> list=FileIoUtil.readFromFile(FILE_NAME);
		String modelName=uuidEnum.getModelName();
		//2
		for(UuidModel uuid: list){
			if(uuid.getModelName().equals(modelName)){
				int result=uuid.getCurrentNum();
				uuid.setCurrentNum(uuid.getCurrentNum()+1);
				FileIoUtil.write2File(list, FILE_NAME);
				return String.valueOf(result);
			}
		}
		int result=1;
		UuidModel uuid=new UuidModel();
		uuid.setModelName(modelName);
		uuid.setCurrentNum(2);
		list.add(uuid);
		FileIoUtil.write2File(list, FILE_NAME);
		return String.valueOf(result);
	}

}
