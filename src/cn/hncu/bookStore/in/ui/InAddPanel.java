/*
 * InAddPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.in.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.in.business.factory.InMainEbiFactory;
import cn.hncu.bookStore.in.vo.InDetailModel;
import cn.hncu.bookStore.in.vo.InMainModel;
import cn.hncu.bookStore.user.business.factory.UserEboFactory;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.utils.FileIoUtil;

/**
 *
 * @author  __USER__
 */
public class InAddPanel extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	private List<InDetailModel> listInDetails = new ArrayList<InDetailModel>();

	/** Creates new form InAddPanel */
	public InAddPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
		myInitData();
	}

	private void myInitData() {
		//1图书选择
		List<BookModel> books = FileIoUtil.readFromFile("Book.txt");
		for (BookModel book : books) {
			combBook.addItem(book);

		}

		//2进货管理员选择
		List<UserModel> inUsers = UserEboFactory.getUserEbi().getAllIn();
		for (UserModel inUser : inUsers) {
			combUser.addItem(inUser);
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
		combBook = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		tfdNum = new javax.swing.JTextField();
		btnDetailAdd = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		listInDetail = new javax.swing.JList();
		jLabel5 = new javax.swing.JLabel();
		combUser = new javax.swing.JComboBox();
		btnAdd = new javax.swing.JButton();
		btnBack = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(255, 102, 102));
		jLabel1.setText("\u6dfb\u52a0\u8fdb\u8d27");
		add(jLabel1);
		jLabel1.setBounds(290, 30, 200, 40);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel2.setText("\u56fe\u4e66\u540d\u79f0\uff1a");
		add(jLabel2);
		jLabel2.setBounds(80, 80, 90, 40);

		combBook.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		combBook.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "请选择..." }));
		add(combBook);
		combBook.setBounds(190, 90, 130, 40);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel3.setText("\u56fe\u4e66\u6570\u91cf\uff1a");
		add(jLabel3);
		jLabel3.setBounds(80, 150, 90, 30);
		add(tfdNum);
		tfdNum.setBounds(190, 150, 120, 30);

		btnDetailAdd.setBackground(new java.awt.Color(153, 153, 255));
		btnDetailAdd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnDetailAdd.setForeground(new java.awt.Color(255, 102, 102));
		btnDetailAdd.setText("\u6dfb\u52a0\u5230\u660e\u7ec6");
		btnDetailAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDetailAddActionPerformed(evt);
			}
		});
		add(btnDetailAdd);
		btnDetailAdd.setBounds(480, 150, 210, 50);

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel4.setForeground(new java.awt.Color(255, 153, 153));
		jLabel4.setText("\u660e\u7ec6\u5217\u8868:");
		add(jLabel4);
		jLabel4.setBounds(40, 210, 120, 30);

		listInDetail.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(listInDetail);

		add(jScrollPane1);
		jScrollPane1.setBounds(30, 260, 450, 210);

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel5.setText("\u8fdb\u8d27\u4eba\u5458\uff1a");
		add(jLabel5);
		jLabel5.setBounds(510, 240, 90, 50);

		combUser.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		combUser.setForeground(new java.awt.Color(102, 204, 255));
		combUser.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "请选择..." }));
		
		add(combUser);
		combUser.setBounds(510, 290, 180, 50);

		btnAdd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnAdd.setForeground(new java.awt.Color(153, 153, 255));
		btnAdd.setText(" \u786e\u8ba4\u6dfb\u52a0");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});
		add(btnAdd);
		btnAdd.setBounds(510, 360, 120, 50);

		btnBack.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnBack.setForeground(new java.awt.Color(102, 204, 255));
		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		add(btnBack);
		btnBack.setBounds(510, 420, 120, 50);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new InListPanel(mainFrame));
		mainFrame.validate();
	}

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		//1
		UserModel inUser = (UserModel) combUser.getSelectedItem();
		String inUserId = inUser.getUuid();
		String userName = inUser.getName();
		
		//2
		InMainModel inMain = new InMainModel();
		inMain.setInUserId(inUserId);
		inMain.setInUserName(userName);
		//3
		boolean isAdd = InMainEbiFactory.getInMainEbi().addInMain(inMain,listInDetails);
		//4
		if (isAdd) {
			mainFrame.setContentPane(new InListPanel(mainFrame));
			mainFrame.validate();
		} else {
			JOptionPane.showMessageDialog(null, "该货单不能添加");
			return;
		}
		

	}

	private void btnDetailAddActionPerformed(java.awt.event.ActionEvent evt) {
		//1获取参数
		BookModel book = null;
		try {
			book = (BookModel) combBook.getSelectedItem();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "请选择图书!");
			return;
		}
		String bookName = book.getName();
		String bookId = book.getUuid();
		int bookNum = 0;
		try {
			bookNum = Integer.parseInt(tfdNum.getText());
		} catch (NumberFormatException e) {
			if (tfdNum.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入图书数量!");
			} else {
				JOptionPane.showMessageDialog(null, "图书数量输入格式错误!");
			}
			return;
		}

		InDetailModel inDetail = new InDetailModel();
		inDetail.setSumNum(bookNum);
		inDetail.setBookId(bookId);
		inDetail.setBookName(bookName);
		listInDetails.add(inDetail);
	
		btnAdd.setEnabled(true);
		
		//3 进货明细列表添加
		echoDetails();

	}

	private void echoDetails() {
		String strInDetails[] = new String[listInDetails.size()];
		for (int i = 0; i < listInDetails.size(); i++) {
			InDetailModel detailModel = listInDetails.get(i);
			String BookName = BookEbiFactory.getBookEbi()
					.getSingle(detailModel.getBookId()).getName();
			strInDetails[i] = "《" + BookName + "》, " + detailModel.getSumNum()
					+ "本";
		}
		listInDetail.setListData(strInDetails);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnDetailAdd;
	private javax.swing.JComboBox combBook;
	private javax.swing.JComboBox combUser;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JList listInDetail;
	private javax.swing.JTextField tfdNum;
	// End of variables declaration//GEN-END:variables

}