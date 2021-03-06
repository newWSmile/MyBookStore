/*
 * UserAddPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.user.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEboFactory;
import cn.hncu.bookStore.user.vo.UserModel;

/**
 *
 * @author  __USER__
 */
public class UserListPanel extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	/** Creates new form UserAddPanel */
	public UserListPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
		myInitComData();
	}
	public UserListPanel(JFrame mainFrame,List<UserModel> listFromQuery) {
		this.mainFrame = mainFrame;
		initComponents();
		listByUsers.setListData(listFromQuery.toArray());
	}

	
	private void myInitComData() {
		UserEbi ebi = UserEboFactory.getUserEbi();
		listByUsers.setListData(ebi.getAll().toArray());
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
		jScrollPane1 = new javax.swing.JScrollPane();
		listByUsers = new javax.swing.JList();
		btnAdd = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnUpdate = new javax.swing.JButton();
		btnQuery = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(255, 102, 102));
		jLabel1.setText("\u7528\u6237\u754c\u9762");
		add(jLabel1);
		jLabel1.setBounds(260, 40, 160, 40);

		listByUsers.setFont(new java.awt.Font("Microsoft YaHei UI", 2, 24));
		listByUsers.setForeground(new java.awt.Color(153, 102, 255));
		listByUsers.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(listByUsers);

		add(jScrollPane1);
		jScrollPane1.setBounds(50, 100, 510, 400);

		btnAdd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnAdd.setForeground(new java.awt.Color(51, 204, 255));
		btnAdd.setText("\u6dfb\u52a0");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});
		add(btnAdd);
		btnAdd.setBounds(600, 110, 160, 60);

		btnDelete.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnDelete.setForeground(new java.awt.Color(255, 153, 153));
		btnDelete.setText("\u5220\u9664");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});
		add(btnDelete);
		btnDelete.setBounds(600, 200, 160, 60);

		btnUpdate.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnUpdate.setForeground(new java.awt.Color(0, 204, 153));
		btnUpdate.setText("\u4fee\u6539");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});
		add(btnUpdate);
		btnUpdate.setBounds(600, 310, 160, 60);

		btnQuery.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnQuery.setForeground(new java.awt.Color(153, 0, 102));
		btnQuery.setText("\u67e5\u8be2");
		btnQuery.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQueryActionPerformed(evt);
			}
		});
		add(btnQuery);
		btnQuery.setBounds(600, 430, 160, 60);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new UserQueryPanle(mainFrame));
		mainFrame.validate();
	}

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		UserModel user = (UserModel) listByUsers.getSelectedValue();
		if (user == null) {
			JOptionPane.showMessageDialog(this, "请选择要修改的用户");
			return;
		}
		String uuid = user.getUuid();
		mainFrame.setContentPane(new UserUpdatePanle(mainFrame, uuid));
		mainFrame.validate();
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		UserModel user = (UserModel) listByUsers.getSelectedValue();
		if (user == null) {
			JOptionPane.showMessageDialog(this, "请选择要删除的用户");
			return;
		}
		String uuid = user.getUuid();
		mainFrame.setContentPane(new UserDeletePanel(mainFrame, uuid));
		mainFrame.validate();
	}

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new UserAddPanel(mainFrame));
		mainFrame.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnQuery;
	private javax.swing.JButton btnUpdate;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JList listByUsers;
	// End of variables declaration//GEN-END:variables

}