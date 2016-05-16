package cn.hncu.bookStore.user.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.common.UserTypeEnum;
import cn.hncu.bookStore.user.dao.dao.UserDAO;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class UserDAOSerImpl implements UserDAO {
	private final String FILE_NAME="User.txt";
	@Override
	public boolean addUser(UserModel user) {
		//1反序列化。将已有的数据表从文件中读取出来
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2判断是否存在
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUuid().equals(user.getUuid())){
				return false;
			}
		}
		//3如果不存在就创建
		list.add(user);
		//4将数据表持久化
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean updateUser(UserModel user) {
		//1反序列化
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2判断是否存在再决定是否修改
		for(int i=0;i<list.size();i++){
			//3如果存在就修改
			if(list.get(i).getUuid().equals(user.getUuid())){
				list.set(i, user);
				//4数据表持久化
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		//3-2如果不存在就返回失败
		return false;
	}

	@Override
	public boolean deleteUser(UserModel user) {
		//1反序列化
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2判断是否存在再决定是否删除
		for(int i=0;i<list.size();i++){
			//3如果存在就删除
			if(list.get(i).getUuid().equals(user.getUuid())){
				list.remove(i);
				//4数据表持久化
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		//3-2如果不存在就返回失败
		return false;
	}

	@Override
	public UserModel getSingle(String uuid) {
		//1反序列化
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2根据唯一编号uuid去list中找，如果找到返回这个对象，否则返回null
		for(UserModel u:list){
			if(u.getUuid().equals(uuid)){
				return u;
			}
		}
		return null;
	}

	@Override
	public List<UserModel> getAll() {
		//1反序列化
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		return list;
	}

	@Override
	public List<UserModel> getByCondition(UserQueryModel uqm) {
		List<UserModel> list=getAll();
		List<UserModel> results=new ArrayList<UserModel>();
		for(UserModel user:list){
			if(uqm.getUuid()!=null&&uqm.getUuid().trim().length()>0){
				if(!user.getUuid().equals(uqm.getUuid())){
					continue;
				}
			}
			if(uqm.getName()!=null&&uqm.getName().trim().length()>0){
				if(user.getName().indexOf(uqm.getName())==-1){
					continue;
				}
			}
			if(uqm.getType()!=0){
				if(uqm.getType()!=user.getType()){
					continue;
				}
			}
			results.add(user);
		}
		return results;
	}


}
