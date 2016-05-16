package cn.hncu.bookStore.common.login.business.ebo;

import java.util.List;

import javax.swing.JOptionPane;

import cn.hncu.bookStore.common.login.business.ebi.LoginEbi;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEboFactory;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class LoginEbo implements LoginEbi{
	
	@Override
	
	public String login(String userName, String pwd) {
		UserModel user =new UserQueryModel();
		
		List<UserModel> users = UserEboFactory.getUserEbi().getAll();
		for(UserModel model:users){
			if(model.getName().equals(userName)){
				user=model;
			}
		}
		if(user==null){
			return "�Բ��𣬸��û�������";
		}
		if(! user.getPwd().equals(pwd)){
			return "����������벻��ȷ";
		}
		return null ;
	}
	

}
