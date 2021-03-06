/*
 * BookUpdatePanle.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.book.ui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.book.vo.BookModel;

/**
 *
 * @author  __USER__
 */
public class BookUpdatePanle extends javax.swing.JPanel {
	private JFrame mainFrame=null;
	private String uuid=null;
	/** Creates new form BookUpdatePanle */
	public BookUpdatePanle(JFrame mainFrame,String uuid) {
		this.mainFrame=mainFrame;
		this.uuid=uuid;
		initComponents();
		myInitDate();
	}

	private void myInitDate() {
		BookModel book=BookEbiFactory.getBookEbi().getSingle(uuid);
		tfdUuid.setText(uuid);
		tfdName.setText(book.getName());
		tfdInPrice.setText(""+book.getInPrice());
		tfdSalePrice.setText(""+book.getSalePrice());
		tfdUuid.setEditable(false);
		
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
		tfdInPrice = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		tfdSalePrice = new javax.swing.JTextField();
		btnBack = new javax.swing.JButton();
		btnUpdate = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(0, 51, 255));
		jLabel1.setText("\u56fe\u4e66\u4fee\u6539\u754c\u9762");
		add(jLabel1);
		jLabel1.setBounds(250, 30, 230, 60);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel2.setForeground(new java.awt.Color(51, 153, 255));
		jLabel2.setText("boid:");
		add(jLabel2);
		jLabel2.setBounds(90, 100, 70, 40);
		add(tfdUuid);
		tfdUuid.setBounds(190, 100, 200, 40);

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
		btnBack.setBounds(450, 440, 130, 50);

		btnUpdate.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnUpdate.setText("\u4fee\u6539");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});
		add(btnUpdate);
		btnUpdate.setBounds(130, 440, 130, 50);
	}// </editor-fold>
	//GEN-END:initComponents

	protected void btnUpdateActionPerformed(ActionEvent evt) {
		//1收集参数
		String uuid = tfdUuid.getText();
		String name = tfdName.getText();
		double inPrice = Double.valueOf(tfdInPrice.getText());
		double salePrice = Double.valueOf(tfdSalePrice.getText());
		//2
		BookModel book = new BookModel();
		book.setUuid(uuid);
		book.setName(name);
		book.setInPrice(inPrice);
		book.setSalePrice(salePrice);
		//3
		boolean isUpate=BookEbiFactory.getBookEbi().updateBook(book);
		if(isUpate){
			mainFrame.setContentPane(new BookListPanle(mainFrame));
			mainFrame.validate();
		}else{
			JOptionPane.showMessageDialog(null, "图书已不存在");
			return;
		}
		
	}

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new BookListPanle(mainFrame));
		mainFrame.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnUpdate;
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