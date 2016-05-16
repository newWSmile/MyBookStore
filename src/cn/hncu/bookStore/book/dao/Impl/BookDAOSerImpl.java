package cn.hncu.bookStore.book.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.bookStore.book.dao.dao.BookDAO;
import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.book.vo.BookQueryModel;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.utils.FileIoUtil;

public class BookDAOSerImpl implements BookDAO {
	private final String FILE_NAME="Book.txt";
	@Override
	public boolean addBook(BookModel book) {
		//1�����л��������е����ݱ���ļ��ж�ȡ����
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2�ж��Ƿ����
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUuid().equals(book.getUuid())){
				return false;
			}
		}
		//3��������ھʹ���
		list.add(book);
		//4�����ݱ�־û�
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean deleteBook(String uuid) {
		BookModel book =getSingle(uuid);
		//1�����л�
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2�ж��Ƿ�����پ����Ƿ�ɾ��
		for(int i=0;i<list.size();i++){
			//3������ھ�ɾ��
			if(list.get(i).getUuid().equals(book.getUuid())){
				list.remove(i);
				//4���ݱ�־û�
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		//3-2��������ھͷ���ʧ��
		return false;
	}

	@Override
	public boolean updateBook(BookModel book) {
		
		//1�����л�
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2�ж��Ƿ�����پ����Ƿ��޸�
		for(int i=0;i<list.size();i++){
			//3������ھ��޸�
			if(list.get(i).getUuid().equals(book.getUuid())){
				list.set(i, book);
				//4���ݱ�־û�
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		//3-2��������ھͷ���ʧ��
		return false;
	}

	@Override
	public BookModel getSingle(String uuid) {
		//1�����л�
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2����Ψһ���Boidȥlist���ң�����ҵ�����������󣬷��򷵻�null
		for(BookModel b:list){
			if(b.getUuid().equals(uuid)){
				return b;
			}
		}
		return null;
	}

	@Override
	public List<BookModel> getAll() {
		//1�����л�
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		return list;
	}

	@Override
	public List<BookModel> getByCondition(BookQueryModel bqm) {
		List<BookModel> list = getAll();
		List<BookModel> results=new ArrayList<BookModel>();
		for(BookModel book:list){
			if(bqm.getUuid()!=null && bqm.getUuid().trim().length()>0){
				if(!bqm.getUuid().equals(book.getUuid())){
					continue;
				}
			}
			if(bqm.getName()!=null && bqm.getName().trim().length()>0){
				if(book.getName().indexOf(bqm.getName())==-1){
					continue;
				}
			}
			if(bqm.getInPrice()>0){
				if(book.getInPrice()<bqm.getInPrice()){
					continue;
				}
			}
			if(bqm.getInPrice2()>0){
				if(book.getInPrice()>bqm.getInPrice2()){
					continue;
				}
			}
			if(bqm.getSalePrice()>0){
				if(book.getSalePrice()<bqm.getSalePrice()){
					continue;
				}
			}
			if(bqm.getSalePrice2()>0){
				if(book.getSalePrice()>bqm.getSalePrice2()){
					continue;
				}
			}
			results.add(book);
			
		}
		return results;
	}
	
	
}
