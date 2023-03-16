package book.library.controller;

import book.library.exception.ResourceNotFoundException;
import book.library.model.Book;
import book.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //get All books (List)(G) /REST API
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //Create Book (G) /REST API
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    //Get Book by id /REST API
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id)
    {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id : " + id));
        return ResponseEntity.ok(book);
    }

    //Update Book by id /REST API
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book bookDetails){

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id : " + id));

        book.setBookName(bookDetails.getBookName());
        book.setBookAuthor(bookDetails.getBookAuthor());
        book.setBookPages(bookDetails.getBookPages());
        book.setBookTag(bookDetails.getBookTag());

        Book updatedBook = bookRepository.save(book);
        return  ResponseEntity.ok(updatedBook);
    }

    //Delete Book by id /REST API
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id:" + id));
        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }


}



