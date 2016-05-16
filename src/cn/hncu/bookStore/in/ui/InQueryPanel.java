/*
 * InQueryPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.in.ui;

import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.in.business.factory.InMainEbiFactory;
import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.in.vo.InMainQueryModel;
import cn.hncu.bookStore.user.business.factory.UserEboFactory;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.utils.DateUtil;

/**
 *
 * @author  __USER__
 */
public class InQueryPanel extends javax.swing.JPanel {
	private JFrame mainFrame = null;

	/** Creates new form InQueryPanel */
	public InQueryPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
		myInitDate();
	}

	private void myInitDate() {
		//把用户选择框填好
		List<UserModel> inUsers = UserEboFactory.getUserEbi().getAllIn();
		for (UserModel inUserModel : inUsers) {
			combInUser.addItem(inUserModel);
		}

		//把图书选择框填好
		List<BookModel> books = BookEbiFactory.getBookEbi().getAll();
		for (BookModel book : books) {
			combBook.addItem(book.getName());
		}

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		tfdInMainUuid = new javax.swing.JTextField();
		combBook = new javax.swing.JComboBox();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		tfdInDetailUuid = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		combInUser = new javax.swing.JComboBox();
		jLabel9 = new javax.swing.JLabel();
		tfdInDate2 = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		tfdInDate = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		tfdInNum = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		tfdInNum2 = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		tfdInMoney = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		tfdInMoney2 = new javax.swing.JTextField();
		btnQuery = new javax.swing.JButton();
		btnBack = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
		jPanel1.setLayout(null);

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel5.setForeground(new java.awt.Color(255, 102, 102));
		jLabel5.setText("\u8fdb\u8d27\u67e5\u8be2\u754c\u9762");
		jPanel1.add(jLabel5);
		jLabel5.setBounds(230, 10, 240, 50);

		jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel6.setForeground(new java.awt.Color(102, 102, 255));
		jLabel6.setText("\u8fdb\u8d27\u7f16\u53f7\uff1a");
		jPanel1.add(jLabel6);
		jLabel6.setBounds(60, 80, 110, 40);
		jPanel1.add(tfdInMainUuid);
		tfdInMainUuid.setBounds(170, 80, 170, 40);

		combBook.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "请选择" }));
		jPanel1.add(combBook);
		combBook.setBounds(520, 250, 190, 40);

		jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel7.setText("\u56fe\u4e66\u540d\u79f0:");
		jPanel1.add(jLabel7);
		jLabel7.setBounds(390, 250, 80, 40);

		jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel8.setText("\u8fdb\u8d27\u8be6\u7ec6\u7f16\u53f7:");
		jPanel1.add(jLabel8);
		jLabel8.setBounds(30, 250, 150, 30);
		jPanel1.add(tfdInDetailUuid);
		tfdInDetailUuid.setBounds(170, 250, 190, 40);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel3.setText("\u8fdb\u8d27\u4eba:");
		jPanel1.add(jLabel3);
		jLabel3.setBounds(370, 80, 70, 40);

		combInUser.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "请选择" }));
		jPanel1.add(combInUser);
		combInUser.setBounds(490, 80, 170, 40);

		jLabel9.setFont(new java.awt.Font("黑体", 1, 18));
		jLabel9.setForeground(new java.awt.Color(0, 0, 204));
		jLabel9.setText("\u8fdb\u8d27\u622a\u6b62\u65e5\u671f\uff1a");
		jPanel1.add(jLabel9);
		jLabel9.setBounds(370, 130, 140, 40);
		jPanel1.add(tfdInDate2);
		tfdInDate2.setBounds(500, 130, 220, 40);

		jLabel10.setFont(new java.awt.Font("黑体", 1, 18));
		jLabel10.setForeground(new java.awt.Color(0, 0, 204));
		jLabel10.setText("\u8fdb\u8d27\u5f00\u59cb\u65e5\u671f\uff1a");
		jPanel1.add(jLabel10);
		jLabel10.setBounds(20, 130, 140, 40);
		jPanel1.add(tfdInDate);
		tfdInDate.setBounds(170, 130, 190, 40);

		jLabel11.setFont(new java.awt.Font("黑体", 1, 18));
		jLabel11.setForeground(new java.awt.Color(0, 0, 204));
		jLabel11.setText("\u8fdb\u8d27\u6700\u5c0f\u6570\u91cf\uff1a");
		jPanel1.add(jLabel11);
		jLabel11.setBounds(20, 310, 140, 40);
		jPanel1.add(tfdInNum);
		tfdInNum.setBounds(190, 310, 170, 40);

		jLabel12.setFont(new java.awt.Font("黑体", 1, 18));
		jLabel12.setForeground(new java.awt.Color(0, 0, 204));
		jLabel12.setText("\u8fdb\u8d27\u6700\u591a\u6570\u91cf\uff1a");
		jPanel1.add(jLabel12);
		jLabel12.setBounds(380, 310, 140, 40);
		jPanel1.add(tfdInNum2);
		tfdInNum2.setBounds(550, 310, 170, 40);

		jLabel13.setFont(new java.awt.Font("黑体", 1, 18));
		jLabel13.setForeground(new java.awt.Color(0, 0, 204));
		jLabel13.setText("\u8fdb\u8d27\u6700\u4f4e\u4ef7\uff1a");
		jPanel1.add(jLabel13);
		jLabel13.setBounds(20, 390, 140, 40);
		jPanel1.add(tfdInMoney);
		tfdInMoney.setBounds(190, 390, 170, 40);

		jLabel14.setFont(new java.awt.Font("黑体", 1, 18));
		jLabel14.setForeground(new java.awt.Color(0, 0, 204));
		jLabel14.setText("\u8fdb\u8d27\u6700\u9ad8\u4ef7\uff1a");
		jPanel1.add(jLabel14);
		jLabel14.setBounds(380, 390, 140, 40);
		jPanel1.add(tfdInMoney2);
		tfdInMoney2.setBounds(550, 390, 170, 40);

		btnQuery.setFont(new java.awt.Font("宋体", 1, 18));
		btnQuery.setText("\u67e5\u8be2");
		btnQuery.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQueryActionPerformed(evt);
			}
		});
		jPanel1.add(btnQuery);
		btnQuery.setBounds(120, 450, 140, 50);

		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		jPanel1.add(btnBack);
		btnBack.setBounds(420, 450, 130, 50);

		jLabel1.setText("\u683c\u5f0f\u5982:2016-04-12");
		jPanel1.add(jLabel1);
		jLabel1.setBounds(190, 170, 220, 40);

		add(jPanel1);
		jPanel1.setBounds(0, 0, 800, 600);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {
		//1获取参数
		String inUuid = tfdInMainUuid.getText();
		String inUserUuid = null;
		if (combInUser.getSelectedIndex() > 0) {
			UserModel user = (UserModel) combInUser.getSelectedItem();
			inUserUuid = user.getUuid();
		}
		String txtInDate = tfdInDate.getText();
		long inDate = 0;
		if (txtInDate != null && txtInDate.trim().length() > 0) {
			txtInDate = txtInDate + " 00:00:00";
			inDate = DateUtil.string2Long(txtInDate, "起始时间输入格式错误");
			if (inDate == -1) {
				return;
			}
		}
		String txtInDate2 = tfdInDate2.getText();
		long inDate2 = 0;
		if (txtInDate2 != null && txtInDate2.trim().length() > 0) {
			txtInDate2 = txtInDate2 + " 23:59:59";
			inDate2 = DateUtil.string2Long(txtInDate2, "截止时间输入格式错误");
			if (inDate2 == -1) {
				return;
			}
		}

		String inDetailUuid = tfdInDetailUuid.getText();
		String bookUuid = null;
		if (combBook.getSelectedIndex() > 0) {
			String bookName = (String) combBook.getSelectedItem();
			bookUuid = BookEbiFactory.getBookEbi().getBookByName(bookName)
					.getUuid();
		}

		int sumNum = 0;
		if (tfdInNum.getText() != null
				&& tfdInNum.getText().trim().length() > 0) {
			try {
				sumNum = Integer.parseInt(tfdInNum.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "最小数量输入格式错误");
				return;
			}
		}
		int sumNum2 = 0;
		if (tfdInNum2.getText() != null
				&& tfdInNum2.getText().trim().length() > 0) {
			try {
				sumNum2 = Integer.parseInt(tfdInNum2.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "最大数量输入格式错误");
				return;
			}
		}
		double sumMoney = 0;
		if (tfdInMoney.getText() != null
				&& tfdInMoney.getText().trim().length() > 0) {
			try {
				sumMoney = Double.parseDouble(tfdInMoney.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "最底价格输入格式错误");
				return;
			}
		}
		double sumMoney2 = 0;
		if (tfdInMoney2.getText() != null
				&& tfdInMoney2.getText().trim().length() > 0) {
			try {
				sumMoney2 = Double.parseDouble(tfdInMoney2.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "最高价格输入格式错误");
				return;
			}
		}

		//2 组织参数
		//InMain
		InMainQueryModel imqm = new InMainQueryModel();
		imqm.setUuid(inUuid);
		imqm.setInUserId(inUserUuid);
		imqm.setInDate(inDate);
		imqm.setInDate2(inDate2);
		//InDetail
		InDetailQueryModel idqm = new InDetailQueryModel();
		idqm.setUuid(inDetailUuid);

		idqm.setBookId(bookUuid);
		idqm.setSumNum(sumNum);
		idqm.setSumNum2(sumNum2);
		idqm.setSumMoney(sumMoney);
		idqm.setSumMoney2(sumMoney2);
		idqm.setInId(inUuid);

		//3调用逻辑层
		Map<InMainModel, List<InDetailModel>> map = InMainEbiFactory
				.getInMainEbi().getByCondition(imqm, idqm);
		mainFrame.setContentPane(new InListPanel(mainFrame, map));
		mainFrame.validate();
	}

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		back();
	}

	private void back() {
		mainFrame.setContentPane(new InListPanel(mainFrame));
		mainFrame.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnQuery;
	private javax.swing.JComboBox combBook;
	private javax.swing.JComboBox combInUser;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField tfdInDate;
	private javax.swing.JTextField tfdInDate2;
	private javax.swing.JTextField tfdInDetailUuid;
	private javax.swing.JTextField tfdInMainUuid;
	private javax.swing.JTextField tfdInMoney;
	private javax.swing.JTextField tfdInMoney2;
	private javax.swing.JTextField tfdInNum;
	private javax.swing.JTextField tfdInNum2;
	// End of variables declaration//GEN-END:variables

}