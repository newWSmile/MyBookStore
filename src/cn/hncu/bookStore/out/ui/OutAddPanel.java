/*
 * OutAddPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.out.ui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.out.business.factory.OutMainEbiFactory;
import cn.hncu.bookStore.out.vo.OutDetailModel;
import cn.hncu.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.bookStore.out.vo.OutMainModel;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEboFactory;
import cn.hncu.bookStore.user.vo.UserModel;

/**
 *
 * @author  __USER__
 */
public class OutAddPanel extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	private List<OutDetailModel> listOutDetails = new ArrayList<OutDetailModel>();

	/** Creates new form OutAddPanel */
	public OutAddPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
		myInitDate();
	}

	private void myInitDate() {
		//图书选择框
		List<BookModel> books = BookEbiFactory.getBookEbi().getAll();
		for (BookModel book : books) {
			combBook.addItem(book.getName());
		}

		//销售人员选择框
		List<UserModel> outUsers = UserEboFactory.getUserEbi().getAllOut();
		for (UserModel outUser : outUsers) {
			combOutUser.addItem(outUser);
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		combBook = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		tfdNum = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		listOutDetail = new javax.swing.JList();
		jLabel5 = new javax.swing.JLabel();
		btnToDetail = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		combOutUser = new javax.swing.JComboBox();
		btnBack = new javax.swing.JButton();
		btnAdd = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(204, 204, 255));
		jLabel1.setText("\u9500\u552e\u6dfb\u52a0\u754c\u9762");
		add(jLabel1);
		jLabel1.setBounds(220, 10, 240, 50);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel2.setText("\u9500\u552e\u5458\uff1a");
		add(jLabel2);
		jLabel2.setBounds(500, 300, 90, 40);

		combBook.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		combBook.setForeground(new java.awt.Color(255, 153, 204));
		combBook.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "请选择" }));
		add(combBook);
		combBook.setBounds(180, 90, 160, 40);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel3.setText("\u56fe\u4e66\u540d\u79f0\uff1a");
		add(jLabel3);
		jLabel3.setBounds(90, 90, 90, 40);
		add(tfdNum);
		tfdNum.setBounds(180, 160, 160, 40);

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel4.setText("\u56fe\u4e66\u6570\u91cf\uff1a");
		add(jLabel4);
		jLabel4.setBounds(90, 160, 90, 40);

		listOutDetail.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		listOutDetail.setForeground(new java.awt.Color(102, 102, 255));
		listOutDetail.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(listOutDetail);

		add(jScrollPane1);
		jScrollPane1.setBounds(90, 290, 390, 220);

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel5.setText("\u660e\u7ec6\u5217\u8868\uff1a");
		add(jLabel5);
		jLabel5.setBounds(90, 240, 90, 40);

		btnToDetail.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnToDetail.setForeground(new java.awt.Color(255, 102, 102));
		btnToDetail.setText("\u6dfb\u52a0\u5230\u660e\u7ec6");
		btnToDetail.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnToDetailActionPerformed(evt);
			}
		});
		add(btnToDetail);
		btnToDetail.setBounds(510, 150, 160, 50);

		jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel6.setText("\u660e\u7ec6\u5217\u8868\uff1a");
		add(jLabel6);
		jLabel6.setBounds(410, 160, 90, 40);

		combOutUser.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		combOutUser.setForeground(new java.awt.Color(153, 153, 255));
		combOutUser.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "请选择..." }));
		add(combOutUser);
		combOutUser.setBounds(580, 300, 170, 40);

		btnBack.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnBack.setForeground(new java.awt.Color(102, 204, 255));
		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		add(btnBack);
		btnBack.setBounds(510, 450, 130, 50);

		btnAdd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnAdd.setForeground(new java.awt.Color(102, 204, 255));
		btnAdd.setText("\u786e\u8ba4\u6dfb\u52a0");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});
		add(btnAdd);
		btnAdd.setBounds(510, 380, 130, 50);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		UserModel outUser=(UserModel) combOutUser.getSelectedItem();
		String outUserName=outUser.getName();
		String outUserUuid=outUser.getUuid();
		
		OutMainModel outMain=new OutMainModel();
		outMain.setOutUserUuid(outUserUuid);
		outMain.setOutUserName(outUserName);
		
		boolean isAdd=OutMainEbiFactory.getOutMainEbi().addOutMain(outMain, listOutDetails);
		if(isAdd){
			mainFrame.setContentPane(new OutListPanel(mainFrame));
			mainFrame.validate();
		}else{
			JOptionPane.showMessageDialog(mainFrame, "该销售货单不可添加");
			return ;
		}
		
	}

	protected void btnToDetailActionPerformed(ActionEvent evt) {
		String bookName = null;
		if (combBook.getSelectedIndex() > 0) {
			bookName = combBook.getSelectedItem().toString();
		}
		int sumNum = 0;
		String strSumNum = tfdNum.getText();
		try {
			sumNum = Integer.parseInt(strSumNum);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "图书数量格式输入错误！");
			return;
		}
		OutDetailModel outDetail = new OutDetailModel();
		outDetail.setBookUuid(BookEbiFactory.getBookEbi()
				.getBookByName(bookName).getUuid());
		outDetail.setSumNum(sumNum);
		outDetail.setBookName(bookName);
		listOutDetails.add(outDetail);
		btnAdd.setEnabled(true);
		echoDetails();
	}

	private void echoDetails() {
		String strOutDetails[] = new String[listOutDetails.size()];
		for (int i = 0; i < listOutDetails.size(); i++) {
			OutDetailModel model = listOutDetails.get(i);
			String bookName = BookEbiFactory.getBookEbi()
					.getSingle(model.getBookUuid()).getName();
			int num = model.getSumNum();
			strOutDetails[i] = "《" + bookName + "》, " + num + "本";
		}
		listOutDetail.setListData(strOutDetails);
	}

	void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new OutListPanel(mainFrame));
		mainFrame.validate();
	}

	//G

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnToDetail;
	private javax.swing.JComboBox combBook;
	private javax.swing.JComboBox combOutUser;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JList listOutDetail;
	private javax.swing.JTextField tfdNum;
	// End of variables declaration//GEN-END:variables

}