package book.library.services;

import book.library.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    Book createBookServ(Book book);

    List<Book> getAllBooksServ();

    Book getBookByIdServ(Long id);

    Book updateBookServ(Long id, Book bookDetails);

    Map<String, Boolean> deleteBookServ(Long id);

}
