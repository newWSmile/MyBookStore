package cn.hncu.bookStore.user.business.ebo;

import java.util.List;

import cn.hncu.bookStore.common.UserTypeEnum;
import cn.hncu.bookStore.common.UuidModelConstance;
import cn.hncu.bookStore.common.uuid.dao.dao.UuidDAO;
import cn.hncu.bookStore.common.uuid.dao.factory.UuidDAOFactory;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.dao.dao.UserDAO;
import cn.hncu.bookStore.user.dao.factory.UserDAOFactory;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;

public class UserEbo implements UserEbi{
	UserDAO dao=UserDAOFactory.getUserDAO();
	@Override
	public boolean addUser(UserModel user) {
		String uuid=UuidDAOFactory.getUuidDAO().getNextUuid(UuidModelConstance.USER);
		user.setUuid(uuid);
		return dao.addUser(user);
	}

	@Override
	public boolean deleteUser(UserModel user) {
		return dao.deleteUser(user);
	}

	@Override
	public boolean updateUser(UserModel user) {
		return dao.updateUser(user);
	}

	@Override
	public UserModel getSingle(String uuid) {
		UserModel user=dao.getSingle(uuid);
		return user;
	}

	@Override
	public List<UserModel> getAll() {
		List<UserModel> list =dao.getAll();
		return list;
	}

	@Override
	public List<UserModel> getByCondition(UserQueryModel uqm) {
		return UserDAOFactory.getUserDAO().getByCondition(uqm);
	}

	@Override
	public List<UserModel> getAllIn() {
		UserQueryModel uqm=new UserQueryModel();
		uqm.setType(UserTypeEnum.IN.getType());
		return getByCondition(uqm);
	}

	@Override
	public List<UserModel> getAllOut() {
		UserQueryModel uqm=new UserQueryModel();
		uqm.setType(UserTypeEnum.OUT.getType());
		return getByCondition(uqm);
	}
	
}
