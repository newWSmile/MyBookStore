package cn.hncu.bookStore.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class DateUtil {
	private DateUtil(){
	}
	public static String long2String(long d){
		Date date=new Date(d);
		DateFormat sdf=new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ HH:mm:ss");
		String str=sdf.format(date);
		return str;
	}
	public static long string2Long(String txtInDate, String erroInfor){
		long inDate=0;
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date d=df.parse(txtInDate);
			inDate=d.getTime();
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, erroInfor);
			inDate=-1;
		}
		
		return inDate;
	}
}
