package cn.hncu.bookStore.book.dao.factory;

import cn.hncu.bookStore.book.dao.Impl.BookDAOSerImpl;
import cn.hncu.bookStore.book.dao.dao.BookDAO;
import cn.hncu.bookStore.book.vo.BookModel;

public class BookDAOFactory {
	public static BookDAO getBookDAO(){
		return new BookDAOSerImpl();
	}
}
