package cn.hncu.bookStore.book.dao.dao;

import java.awt.print.Book;
import java.util.List;

import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.book.vo.BookQueryModel;

public interface BookDAO {
	public boolean addBook(BookModel book);
	public boolean deleteBook(String uuid);
	public boolean updateBook(BookModel book);
	
	public BookModel getSingle(String uuid);
	public List<BookModel> getAll();
	public List<BookModel> getByCondition(BookQueryModel bqm);
}
