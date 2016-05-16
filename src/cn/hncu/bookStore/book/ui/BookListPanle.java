/*
 * BookListPanle.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.book.ui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.ebi.BookEbi;
import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.utils.SetBack;

/**
 *
 * @author  __USER__
 */
public class BookListPanle extends javax.swing.JPanel {
	private JFrame mainFrame = null;

	/** Creates new form BookListPanle */
	public BookListPanle(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
		myInitComDate();
		SetBack.setBack(this,"query");
	}

	public BookListPanle(JFrame mainFrame, List<BookModel> results) {
		this.mainFrame = mainFrame;
		initComponents();
		listByBooks.setListData(results.toArray());
	}

	private void myInitComDate() {
		BookEbi ebi = BookEbiFactory.getBookEbi();
		List<BookModel> list = ebi.getAll();
		listByBooks.setListData(list.toArray());
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		listByBooks = new javax.swing.JList();
		btnAdd = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnQuery = new javax.swing.JButton();
		btnUpdate = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 36));
		jLabel1.setForeground(new java.awt.Color(204, 204, 255));
		jLabel1.setText("\u56fe\u4e66\u754c\u9762");
		add(jLabel1);
		jLabel1.setBounds(290, 10, 180, 50);

		listByBooks.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		listByBooks.setForeground(new java.awt.Color(204, 153, 255));
		listByBooks.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(listByBooks);

		add(jScrollPane1);
		jScrollPane1.setBounds(20, 70, 740, 350);

		btnAdd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnAdd.setForeground(new java.awt.Color(255, 153, 153));
		btnAdd.setText("\u6dfb\u52a0\u56fe\u4e66");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});
		add(btnAdd);
		btnAdd.setBounds(40, 450, 140, 60);

		btnDelete.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnDelete.setForeground(new java.awt.Color(0, 204, 204));
		btnDelete.setText("\u5220\u9664\u56fe\u4e66");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});
		add(btnDelete);
		btnDelete.setBounds(220, 450, 140, 60);

		btnQuery.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnQuery.setForeground(new java.awt.Color(0, 204, 102));
		btnQuery.setText("\u67e5\u627e\u56fe\u4e66");
		btnQuery.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQueryActionPerformed(evt);
			}
		});
		add(btnQuery);
		btnQuery.setBounds(610, 450, 140, 60);

		btnUpdate.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnUpdate.setForeground(new java.awt.Color(255, 102, 102));
		btnUpdate.setText("\u4fee\u6539\u56fe\u4e66");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});
		add(btnUpdate);
		btnUpdate.setBounds(410, 450, 140, 60);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new BookQueryPanle(mainFrame));
		mainFrame.validate();
	}

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		BookModel book = (BookModel) listByBooks.getSelectedValue();
		if (book == null) {
			JOptionPane.showMessageDialog(mainFrame, "«Î—°‘ÒÕº È");
			return;
		}
		String uuid = book.getUuid();
		mainFrame.setContentPane(new BookUpdatePanle(mainFrame, uuid));
		mainFrame.validate();
	}

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {

		mainFrame.setContentPane(new BookAddPanle(mainFrame));
		mainFrame.validate();
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		BookModel book = (BookModel) listByBooks.getSelectedValue();
		String uuid = book.getUuid();
		mainFrame.setContentPane(new BookDeletePanle(mainFrame, uuid));
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
	private javax.swing.JList listByBooks;
	// End of variables declaration//GEN-END:variables

}