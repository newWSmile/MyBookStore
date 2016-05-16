package cn.hncu.bookStore.book.business.ebo;

import java.util.List;

import cn.hncu.bookStore.book.business.ebi.BookEbi;
import cn.hncu.bookStore.book.dao.dao.BookDAO;
import cn.hncu.bookStore.book.dao.factory.BookDAOFactory;
import cn.hncu.bookStore.book.vo.BookModel;
import cn.hncu.bookStore.book.vo.BookQueryModel;
import cn.hncu.bookStore.common.UuidModelConstance;
import cn.hncu.bookStore.common.uuid.dao.factory.UuidDAOFactory;
import cn.hncu.bookStore.user.vo.UserModel;

public class BookEbo implements BookEbi{
	private BookDAO dao=BookDAOFactory.getBookDAO();
	@Override
	public boolean addBook(BookModel book) {
		String uuid=UuidDAOFactory.getUuidDAO().getNextUuid(UuidModelConstance.BOOK);
		book.setUuid(uuid);
		return dao.addBook(book);
	}

	@Override
	public boolean deleteBook(String uuid) {
		return dao.deleteBook(uuid);
	}

	@Override
	public boolean updateBook(BookModel book) {
		return dao.updateBook(book);
	}

	@Override
	public BookModel getSingle(String boid) {
		return dao.getSingle(boid);
	}

	@Override
	public List<BookModel> getAll() {
		return dao.getAll();
	}

	@Override
	public List<BookModel> getByCondition(BookQueryModel bqm) {
		return dao.getByCondition(bqm);
	}

	
	@Override
	public BookModel getBookByName(String bookName) {
		BookQueryModel bqm=new BookQueryModel();
		bqm.setName(bookName);
		return getByCondition(bqm).get(0);
	}

}
