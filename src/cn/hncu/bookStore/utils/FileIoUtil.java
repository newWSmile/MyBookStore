package cn.hncu.bookStore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class FileIoUtil {
	/**
	 * 功能：把数据表文件写到文件中去
	 * @param list  要写入的数据表
	 * @param fileName  数据表要写入的文件名
	 */
	public static<E> void write2File(List<E> list,String fileName){
		ObjectOutputStream out=null;
		try {
			out=new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					throw new RuntimeException("数据文件关流失败");
				}
			}
		}
	}
	
	/**
	 * 
	 * @param fileName 要读的数据表的文件名
	 * @param ee	把数据表读到一个集合中的泛型
	 * @return	一个集合即数据表
	 */
	@SuppressWarnings("unchecked")
	public static<E> List<E> readFromFile(String fileName){
		List<E> list=new ArrayList<E>();
		File file=new File(fileName);
		if(!file.exists()){
			JOptionPane.showMessageDialog(null, "数据表不存在");
			return list;
		}
		ObjectInputStream in=null;
		try {
			in=new ObjectInputStream(new FileInputStream(fileName));
			try {
				list=(List<E>) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException("数据关流失败");
				}
			}
		}
		return list;
	}
}
