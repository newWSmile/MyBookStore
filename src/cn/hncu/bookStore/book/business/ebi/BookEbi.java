package cn.hncu.bookStore.book.business.ebi;

import java.util.List;

import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.book.vo.BookQueryModel;
import cn.hncu.bookStore.user.vo.UserModel;

public interface BookEbi {
	public boolean addBook(BookModel book);
	public boolean deleteBook(String uuid);
	public boolean updateBook(BookModel book);
	
	public BookModel getBookByName(String bookName);
	
	public BookModel getSingle(String uuid);
	public List<BookModel> getAll();
	public List<BookModel> getByCondition(BookQueryModel bqm);
}
