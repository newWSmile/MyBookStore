/*
 * BookDeletePanle.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.book.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.book.vo.BookModel;

/**
 *
 * @author  __USER__
 */
public class BookDeletePanle extends javax.swing.JPanel {
	private JFrame mainFrame = null;
	private String uuid = null;

	/** Creates new form BookDeletePanle */
	public BookDeletePanle(JFrame mainFrame, String uuid) {
		this.mainFrame = mainFrame;
		this.uuid = uuid;
		initComponents();
		myInitDate();
	}

	private void myInitDate() {
		BookModel book = BookEbiFactory.getBookEbi().getSingle(uuid);
		tfdUuid.setText(uuid);
		tfdName.setText(book.getName());
		tfdInPrice.setText("" + book.getInPrice());
		tfdSalePrice.setText("" + book.getSalePrice());
		tfdUuid.setEditable(false);
		tfdName.setEditable(false);
		tfdInPrice.setEditable(false);
		tfdSalePrice.setEditable(false);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		tfdUuid = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		tfdName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		tfdInPrice = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		tfdSalePrice = new javax.swing.JTextField();
		btnBack = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(0, 51, 255));
		jLabel1.setText("\u56fe\u4e66\u5220\u9664\u754c\u9762");
		add(jLabel1);
		jLabel1.setBounds(250, 30, 230, 60);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel2.setForeground(new java.awt.Color(51, 153, 255));
		jLabel2.setText("boid:");
		add(jLabel2);
		jLabel2.setBounds(90, 110, 70, 40);
		add(tfdUuid);
		tfdUuid.setBounds(190, 110, 200, 40);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel3.setForeground(new java.awt.Color(204, 0, 102));
		jLabel3.setText("\u56fe\u4e66\u540d\u79f0:");
		add(jLabel3);
		jLabel3.setBounds(50, 170, 110, 40);
		add(tfdName);
		tfdName.setBounds(190, 170, 220, 40);

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel4.setText("\u56fe\u4e66\u8fdb\u4ef7:");
		add(jLabel4);
		jLabel4.setBounds(80, 230, 80, 50);
		add(tfdInPrice);
		tfdInPrice.setBounds(190, 230, 270, 40);

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel5.setText("\u56fe\u4e66\u552e\u4ef7:");
		add(jLabel5);
		jLabel5.setBounds(80, 320, 80, 50);
		add(tfdSalePrice);
		tfdSalePrice.setBounds(190, 320, 270, 40);

		btnBack.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		add(btnBack);
		btnBack.setBounds(420, 440, 130, 50);

		btnDelete.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnDelete.setText("\u5220\u9664");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});
		add(btnDelete);
		btnDelete.setBounds(130, 440, 130, 50);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new BookListPanle(mainFrame));
		mainFrame.validate();
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		boolean isDelete = BookEbiFactory.getBookEbi().deleteBook(uuid);
		if (isDelete) {
			mainFrame.setContentPane(new BookListPanle(mainFrame));
			mainFrame.validate();
		} else {
			JOptionPane.showMessageDialog(null, "图书已不存在");
			return;
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnDelete;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JTextField tfdInPrice;
	private javax.swing.JTextField tfdName;
	private javax.swing.JTextField tfdSalePrice;
	private javax.swing.JTextField tfdUuid;
	// End of variables declaration//GEN-END:variables

}