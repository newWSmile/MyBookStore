package cn.hncu.bookStore.user.dao.dao;

import java.util.List;

import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;

public interface UserDAO {
	/**
	 * ���ܣ�����һ���û�
	 * @param user userģ����VO����д��ֵ����
	 * @return  true��ʾ�����û��ɹ�;false��ʾ�����û�ʧ�ܣ�
	 */
	public boolean addUser(UserModel user);
	/**
	 *  ���ܣ�ɾ��һ���û�
	 * @param user userģ����VO����д��ֵ����
	 * @return  true��ʾɾ���û��ɹ�;false��ʾɾ���û�ʧ�ܣ�
	 */
	public boolean deleteUser(UserModel user);
	/**
	 *  ���ܣ�����һ���û�
	 * @param user userģ����VO����д��ֵ����
	 * @return  true��ʾ�����û��ɹ�;false��ʾ�����û�ʧ�ܣ�
	 */
	public boolean updateUser(UserModel user);
	
	/**
	 * ���ܣ������û���Ψһ����ҵ�����û�
	 * @param uuid �û���Ψһ���
	 * @return ����û�
	 */
	public UserModel getSingle(String uuid);
	/**
	 * ���ܣ���������û�
	 * @return
	 */
	public List<UserModel> getAll();
	/**
	 * ���ܣ�����������������÷��ϸ��������û�
	 * @param uqm userģ����VO���װ�����Ķ���
	 * @return  �����������û�
	 */
	public List<UserModel> getByCondition(UserQueryModel uqm);
	
	
}
