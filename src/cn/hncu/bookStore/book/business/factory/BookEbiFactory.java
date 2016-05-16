package cn.hncu.bookStore.book.business.factory;

import cn.hncu.bookStore.book.business.ebi.BookEbi;
import cn.hncu.bookStore.book.business.ebo.BookEbo;

public class BookEbiFactory {
	public static BookEbi getBookEbi(){
		return new BookEbo();
	}
}
