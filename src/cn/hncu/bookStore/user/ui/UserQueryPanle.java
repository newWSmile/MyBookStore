/*
 * UserQueryPanle.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.user.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.common.UserTypeEnum;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEboFactory;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;

/**
 *
 * @author  __USER__
 */
public class UserQueryPanle extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	/** Creates new form UserQueryPanle */
	public UserQueryPanle(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
		myInitComDate();
	}

	private void myInitComDate() {
		for (UserTypeEnum userType : UserTypeEnum.values()) {
			combType.addItem(userType.getName());
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		tfdUuid = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		tfdName = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		combType = new javax.swing.JComboBox();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		
		btnQuery = new javax.swing.JButton();
		btnBack = new javax.swing.JButton();
		

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(153, 153, 255));
		jLabel1.setText("\u67e5\u8be2\u7528\u6237\u754c\u9762");
		add(jLabel1);
		jLabel1.setBounds(260, 30, 230, 50);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel2.setForeground(new java.awt.Color(51, 153, 255));
		jLabel2.setText("uuid:");
		add(jLabel2);
		jLabel2.setBounds(80, 150, 70, 40);
		add(tfdUuid);
		tfdUuid.setBounds(170, 150, 200, 40);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel3.setForeground(new java.awt.Color(204, 0, 102));
		jLabel3.setText("\u59d3\u540d:");
		add(jLabel3);
		jLabel3.setBounds(80, 270, 70, 40);
		add(tfdName);
		tfdName.setBounds(170, 270, 220, 40);

		jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel6.setForeground(new java.awt.Color(0, 204, 255));
		jLabel6.setText("\u7528\u6237\u7c7b\u578b\uff1a");
		add(jLabel6);
		jLabel6.setBounds(60, 400, 140, 40);

		combType.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "请选择用户类型..." }));
		add(combType);
		combType.setBounds(200, 400, 210, 40);

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel4.setForeground(new java.awt.Color(204, 0, 102));
		jLabel4.setText("\u6839\u636e\u7528\u6237\u7c7b\u578b\u67e5\u8be2\uff1a");
		add(jLabel4);
		jLabel4.setBounds(50, 350, 200, 32);

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel5.setForeground(new java.awt.Color(204, 0, 102));
		jLabel5.setText("\u6839\u636e\u7528\u6237ID\u67e5\u8be2\uff1a");
		add(jLabel5);
		jLabel5.setBounds(50, 110, 200, 32);

		jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel7.setForeground(new java.awt.Color(204, 0, 102));
		jLabel7.setText("\u6839\u636e\u7528\u6237\u59d3\u540d\u67e5\u8be2\uff1a");
		add(jLabel7);
		jLabel7.setBounds(50, 220, 200, 32);

		

		
		

		btnQuery.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnQuery.setForeground(new java.awt.Color(255, 153, 153));
		btnQuery.setText("\u7efc\u5408\u67e5\u8be2");
		btnQuery.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQueryActionPerformed(evt);
			}
		});
		add(btnQuery);
		btnQuery.setBounds(80, 480, 150, 50);

		btnBack.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnBack.setForeground(new java.awt.Color(255, 102, 204));
		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		add(btnBack);
		btnBack.setBounds(410, 480, 140, 50);
		
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new UserListPanel(mainFrame));
		mainFrame.validate();
	}

	private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {
		String uuid = tfdUuid.getText();
		String name = tfdName.getText();
		int type = 0;
		try {
			type = UserTypeEnum.getTypeByName((String) combType
					.getSelectedItem());
		} catch (Exception e) {
		}
		UserQueryModel uqm=new UserQueryModel();
		uqm.setName(name);
		uqm.setUuid(uuid);
		uqm.setType(type);
		UserEbi ebi = UserEboFactory.getUserEbi();
		
		List<UserModel> results = ebi.getByCondition(uqm);
		mainFrame.setContentPane(new UserListPanel(mainFrame,results));
		mainFrame.validate();

	}

	

	

//GEN-BEGIN:variables
// Variables declaration - do not modify
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnQuery;
	private javax.swing.JComboBox combType;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JTextField tfdName;
	private javax.swing.JTextField tfdUuid;
	// End of variables declaration//GEN-END:variables

}