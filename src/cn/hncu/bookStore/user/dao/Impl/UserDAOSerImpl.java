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
		//1�����л��������е����ݱ���ļ��ж�ȡ����
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2�ж��Ƿ����
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUuid().equals(user.getUuid())){
				return false;
			}
		}
		//3��������ھʹ���
		list.add(user);
		//4�����ݱ�־û�
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean updateUser(UserModel user) {
		//1�����л�
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2�ж��Ƿ�����پ����Ƿ��޸�
		for(int i=0;i<list.size();i++){
			//3������ھ��޸�
			if(list.get(i).getUuid().equals(user.getUuid())){
				list.set(i, user);
				//4���ݱ�־û�
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		//3-2��������ھͷ���ʧ��
		return false;
	}

	@Override
	public boolean deleteUser(UserModel user) {
		//1�����л�
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2�ж��Ƿ�����پ����Ƿ�ɾ��
		for(int i=0;i<list.size();i++){
			//3������ھ�ɾ��
			if(list.get(i).getUuid().equals(user.getUuid())){
				list.remove(i);
				//4���ݱ�־û�
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		//3-2��������ھͷ���ʧ��
		return false;
	}

	@Override
	public UserModel getSingle(String uuid) {
		//1�����л�
		List<UserModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2����Ψһ���uuidȥlist���ң�����ҵ�����������󣬷��򷵻�null
		for(UserModel u:list){
			if(u.getUuid().equals(uuid)){
				return u;
			}
		}
		return null;
	}

	@Override
	public List<UserModel> getAll() {
		//1�����л�
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
