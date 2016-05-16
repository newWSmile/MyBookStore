package cn.hncu.bookStore.utils;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SetBack {
	public static void setBack(JPanel panel,String txtName){
		String filename="E:\\MyEclipse´úÂëÇø\\AddressManageApp\\image\\"+txtName+".jpg";
		panel.setOpaque(false);
		Icon image=new ImageIcon(filename);
		JLabel bgLbl=new JLabel(image);
		bgLbl.setBounds(0, 0, 800, 600);
		panel.add(bgLbl,new Integer(Integer.MIN_VALUE));
		panel.validate();
	}
}
