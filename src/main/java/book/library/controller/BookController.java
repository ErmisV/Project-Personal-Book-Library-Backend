package book.library.controller;

import book.library.model.Book;
import book.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //get all books
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

}
