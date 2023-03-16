package book.library.controller;

import book.library.exception.ResourceNotFoundException;
import book.library.model.Book;
import book.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //get all books REST API
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //Book REST API
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    //Get Book by id REST API
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id)
    {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id : " + id));
        return ResponseEntity.ok(book);
    }
}
