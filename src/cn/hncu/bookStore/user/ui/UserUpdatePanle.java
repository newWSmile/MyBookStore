/*
 * UserUpdatePanle.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.user.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.common.UserTypeEnum;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEboFactory;
import cn.hncu.bookStore.user.vo.UserModel;

/**
 *
 * @author  __USER__
 */
public class UserUpdatePanle extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	private String uuid = null;

	/** Creates new form UserUpdatePanle */
	public UserUpdatePanle(JFrame mainFrame, String uuid) {
		this.mainFrame = mainFrame;
		this.uuid = uuid;
		initComponents();
		myInitComDate();
	}

	private void myInitComDate() {
		UserEbi ebi = UserEboFactory.getUserEbi();
		UserModel user = ebi.getSingle(uuid);
		
		tfdUuid.setText(user.getUuid());
		tfdUuid.setEditable(false);
		tfdName.setText(user.getName());
		ptfPwd.setText(user.getPwd());
		ptfPwd2.setText(user.getPwd());
		
		combTypes.removeAllItems();

		combTypes.addItem(UserTypeEnum.getNameByType(user.getType()));
		for (UserTypeEnum userType : UserTypeEnum.values()) {
			if (userType.getType() != user.getType()) {
				combTypes.addItem(userType.getName());
			}
		}

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		tfdUuid = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		tfdName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		ptfPwd = new javax.swing.JPasswordField();
		jLabel5 = new javax.swing.JLabel();
		ptfPwd2 = new javax.swing.JPasswordField();
		combTypes = new javax.swing.JComboBox();
		jLabel6 = new javax.swing.JLabel();
		btnUpdate = new javax.swing.JButton();
		btnBack = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(0, 51, 255));
		jLabel1.setText("\u7528\u6237\u4fee\u6539\u754c\u9762");
		add(jLabel1);
		jLabel1.setBounds(250, 30, 230, 60);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel2.setForeground(new java.awt.Color(51, 153, 255));
		jLabel2.setText("uuid:");
		add(jLabel2);
		jLabel2.setBounds(90, 110, 70, 40);
		add(tfdUuid);
		tfdUuid.setBounds(170, 110, 200, 40);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel3.setForeground(new java.awt.Color(204, 0, 102));
		jLabel3.setText("\u59d3\u540d:");
		add(jLabel3);
		jLabel3.setBounds(410, 110, 70, 40);
		add(tfdName);
		tfdName.setBounds(480, 110, 220, 40);

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel4.setForeground(new java.awt.Color(204, 204, 255));
		jLabel4.setText("\u5bc6\u7801\uff1a");
		add(jLabel4);
		jLabel4.setBounds(90, 190, 80, 30);
		add(ptfPwd);
		ptfPwd.setBounds(170, 190, 290, 40);

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel5.setForeground(new java.awt.Color(255, 204, 204));
		jLabel5.setText("\u786e\u8ba4\u5bc6\u7801:");
		add(jLabel5);
		jLabel5.setBounds(60, 270, 130, 30);
		add(ptfPwd2);
		ptfPwd2.setBounds(170, 260, 300, 40);

		combTypes.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "" }));
		add(combTypes);
		combTypes.setBounds(180, 350, 230, 40);

		jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel6.setForeground(new java.awt.Color(0, 204, 255));
		jLabel6.setText("\u7528\u6237\u7c7b\u578b\uff1a");
		add(jLabel6);
		jLabel6.setBounds(50, 350, 140, 40);

		btnUpdate.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24));
		btnUpdate.setForeground(new java.awt.Color(0, 204, 102));
		btnUpdate.setText("\u4fee\u6539");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});
		add(btnUpdate);
		btnUpdate.setBounds(90, 470, 130, 50);

		btnBack.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		btnBack.setForeground(new java.awt.Color(153, 0, 51));
		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		add(btnBack);
		btnBack.setBounds(410, 470, 120, 50);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		//1收集数据
		
		String name = tfdName.getText();
		String pwd = new String(ptfPwd.getPassword());
		String pwd2 = new String(ptfPwd2.getPassword());
		if (!pwd.equals(pwd2)) {
			JOptionPane.showMessageDialog(null, "两次输入密码不一致！请重新输入密码");
			return;
		}
		int type =0;
		try {
			type= UserTypeEnum.getTypeByName(combTypes.getSelectedItem()
					.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "请选择用户类型");
			return;
		}
		//2组织参数
		UserModel user = new UserModel();
		user.setName(name);
		user.setUuid(uuid);
		user.setType(type);
		if(type==0){
			JOptionPane.showMessageDialog(null, "请选择用户类型");
			return;
		}
		user.setPwd(pwd);
		//3调用逻辑层
		UserEbi ebi=UserEboFactory.getUserEbi();
		boolean isUpdate=ebi.updateUser(user);
		//4根据返回结果导向不同界面
		if(isUpdate){
			back();
		}else{
			JOptionPane.showMessageDialog(null, "该用户不存在，修改失败！");
			return;
		}
	}

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		back();
	}

	private void back() {
		mainFrame.setContentPane(new UserListPanel(mainFrame));
		mainFrame.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnUpdate;
	private javax.swing.JComboBox combTypes;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPasswordField ptfPwd;
	private javax.swing.JPasswordField ptfPwd2;
	private javax.swing.JTextField tfdName;
	private javax.swing.JTextField tfdUuid;
	// End of variables declaration//GEN-END:variables

}