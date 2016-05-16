/*
 * BookQueryPanle.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.book.ui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.hncu.bookStore.book.business.factory.BookEbiFactory;
import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.book.vo.BookQueryModel;

/**
 *
 * @author  __USER__
 */
public class BookQueryPanle extends javax.swing.JPanel {
	private JFrame mainFrame = null;

	/** Creates new form BookQueryPanle */
	public BookQueryPanle(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
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
		btnQuery = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		tfdInPrice2 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		tfdSalePrice2 = new javax.swing.JTextField();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(0, 51, 255));
		jLabel1.setText("\u56fe\u4e66\u67e5\u8be2\u754c\u9762");
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
		jLabel4.setText("--------");
		add(jLabel4);
		jLabel4.setBounds(290, 240, 80, 50);
		add(tfdInPrice);
		tfdInPrice.setBounds(160, 250, 120, 40);

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel5.setText("-------");
		add(jLabel5);
		jLabel5.setBounds(290, 300, 70, 50);
		add(tfdSalePrice);
		tfdSalePrice.setBounds(160, 310, 120, 40);

		btnBack.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		add(btnBack);
		btnBack.setBounds(450, 440, 130, 50);

		btnQuery.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		btnQuery.setText("\u67e5\u8be2");
		btnQuery.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQueryActionPerformed(evt);
			}
		});
		add(btnQuery);
		btnQuery.setBounds(130, 440, 130, 50);

		jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel6.setText("\u56fe\u4e66\u8fdb\u4ef7:");
		add(jLabel6);
		jLabel6.setBounds(70, 240, 80, 50);
		add(tfdInPrice2);
		tfdInPrice2.setBounds(390, 250, 120, 40);

		jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel7.setText("\u56fe\u4e66\u552e\u4ef7:");
		add(jLabel7);
		jLabel7.setBounds(70, 310, 80, 50);
		add(tfdSalePrice2);
		tfdSalePrice2.setBounds(390, 310, 120, 40);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {
		String uuid = tfdUuid.getText();
		String name = tfdName.getText();
		double inPrice = 0;
		if(tfdInPrice!=null && tfdInPrice.getText().trim().length()>0){
			try {
				inPrice = Double.parseDouble(tfdInPrice.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(mainFrame, "输入格式错误!");
				return ;
			}
		}
		double inPrice2 = 0;
		if(tfdInPrice2!=null && tfdInPrice2.getText().trim().length()>0){
			try {
				inPrice2 = Double.parseDouble(tfdInPrice2.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(mainFrame, "输入格式错误!");
				return ;
			}
		}
		double salePrice=0;
		if(tfdSalePrice!=null && tfdSalePrice.getText().trim().length()>0){
			try {
				salePrice = Double.parseDouble(tfdSalePrice.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(mainFrame, "输入格式错误!");
				return ;
			}
		}
		double salePrice2=0;
		if(tfdSalePrice2!=null && tfdSalePrice2.getText().trim().length()>0){
			try {
				salePrice2 = Double.parseDouble(tfdSalePrice2.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(mainFrame, "输入格式错误!");
				return ;
			}
		}
		
		//2
		BookQueryModel bqm=new BookQueryModel();
		bqm.setUuid(uuid);
		bqm.setName(name);
		bqm.setInPrice(inPrice);
		bqm.setInPrice2(inPrice2);
		bqm.setSalePrice(salePrice);
		bqm.setSalePrice2(salePrice2);
		
		//3
		List<BookModel> results=BookEbiFactory.getBookEbi().getByCondition(bqm);
		mainFrame.setContentPane(new BookListPanle(mainFrame,results));
		mainFrame.validate();
	}

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		mainFrame.setContentPane(new BookListPanle(mainFrame));
		mainFrame.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnQuery;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JTextField tfdInPrice;
	private javax.swing.JTextField tfdInPrice2;
	private javax.swing.JTextField tfdName;
	private javax.swing.JTextField tfdSalePrice;
	private javax.swing.JTextField tfdSalePrice2;
	private javax.swing.JTextField tfdUuid;
	// End of variables declaration//GEN-END:variables

}