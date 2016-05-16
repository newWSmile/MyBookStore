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
		//1反序列化。将已有的数据表从文件中读取出来
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2判断是否存在
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUuid().equals(book.getUuid())){
				return false;
			}
		}
		//3如果不存在就创建
		list.add(book);
		//4将数据表持久化
		FileIoUtil.write2File(list, FILE_NAME);
		return true;
	}

	@Override
	public boolean deleteBook(String uuid) {
		BookModel book =getSingle(uuid);
		//1反序列化
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2判断是否存在再决定是否删除
		for(int i=0;i<list.size();i++){
			//3如果存在就删除
			if(list.get(i).getUuid().equals(book.getUuid())){
				list.remove(i);
				//4数据表持久化
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		//3-2如果不存在就返回失败
		return false;
	}

	@Override
	public boolean updateBook(BookModel book) {
		
		//1反序列化
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2判断是否存在再决定是否修改
		for(int i=0;i<list.size();i++){
			//3如果存在就修改
			if(list.get(i).getUuid().equals(book.getUuid())){
				list.set(i, book);
				//4数据表持久化
				FileIoUtil.write2File(list, FILE_NAME);
				return true;
			}
		}
		//3-2如果不存在就返回失败
		return false;
	}

	@Override
	public BookModel getSingle(String uuid) {
		//1反序列化
		List<BookModel> list=FileIoUtil.readFromFile(FILE_NAME);
		//2根据唯一编号Boid去list中找，如果找到返回这个对象，否则返回null
		for(BookModel b:list){
			if(b.getUuid().equals(uuid)){
				return b;
			}
		}
		return null;
	}

	@Override
	public List<BookModel> getAll() {
		//1反序列化
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
