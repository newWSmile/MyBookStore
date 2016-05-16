package cn.hncu.bookStore.user.dao.dao;

import java.util.List;

import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;

public interface UserDAO {
	/**
	 * 功能：创建一个用户
	 * @param user user模块中VO层所写的值对象
	 * @return  true表示创建用户成功;false表示创建用户失败；
	 */
	public boolean addUser(UserModel user);
	/**
	 *  功能：删除一个用户
	 * @param user user模块中VO层所写的值对象
	 * @return  true表示删除用户成功;false表示删除用户失败；
	 */
	public boolean deleteUser(UserModel user);
	/**
	 *  功能：更新一个用户
	 * @param user user模块中VO层所写的值对象
	 * @return  true表示更新用户成功;false表示更新用户失败；
	 */
	public boolean updateUser(UserModel user);
	
	/**
	 * 功能：根据用户的唯一编号找到这个用户
	 * @param uuid 用户的唯一编号
	 * @return 这个用户
	 */
	public UserModel getSingle(String uuid);
	/**
	 * 功能：获得所有用户
	 * @return
	 */
	public List<UserModel> getAll();
	/**
	 * 功能：根据所给的条件获得符合改条件的用户
	 * @param uqm user模块中VO层封装条件的对象
	 * @return  符合条件的用户
	 */
	public List<UserModel> getByCondition(UserQueryModel uqm);
	
	
}
