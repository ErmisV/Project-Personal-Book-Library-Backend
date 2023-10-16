package book.library.services;

import book.library.exceptions.ResourceNotFoundException;
import book.library.entity.Book;
import book.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImp implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBookServ(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooksServ() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIdServ (Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id : " + id));
        return book;
    }

    @Override
    public Book updateBookServ(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id : " + id));

        book.setBookName(bookDetails.getBookName());
        book.setBookAuthor(bookDetails.getBookAuthor());
        book.setBookPages(bookDetails.getBookPages());
        book.setBookReads(bookDetails.getBookReads());
        book.setBookProgress(bookDetails.getBookProgress());
        book.setBookTags(bookDetails.getBookTags());

        return bookRepository.save(book);
    }

    @Override
    public Map<String, Boolean> deleteBookServ (Long id) {
       Book book = bookRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id:" + id));
       bookRepository.delete(book);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
    }
}
