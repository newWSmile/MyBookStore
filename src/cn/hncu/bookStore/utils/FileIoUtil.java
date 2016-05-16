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
	 * ���ܣ������ݱ��ļ�д���ļ���ȥ
	 * @param list  Ҫд������ݱ�
	 * @param fileName  ���ݱ�Ҫд����ļ���
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
					throw new RuntimeException("�����ļ�����ʧ��");
				}
			}
		}
	}
	
	/**
	 * 
	 * @param fileName Ҫ�������ݱ���ļ���
	 * @param ee	�����ݱ����һ�������еķ���
	 * @return	һ�����ϼ����ݱ�
	 */
	@SuppressWarnings("unchecked")
	public static<E> List<E> readFromFile(String fileName){
		List<E> list=new ArrayList<E>();
		File file=new File(fileName);
		if(!file.exists()){
			JOptionPane.showMessageDialog(null, "���ݱ�����");
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
					throw new RuntimeException("���ݹ���ʧ��");
				}
			}
		}
		return list;
	}
}
