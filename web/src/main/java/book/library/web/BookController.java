package book.library.web;

import book.library.models.Book;
import book.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class BookController {

    @Autowired
    private BookService bookService;

    //Create Book
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return bookService.createBookServ(book);
    }

    //get All books (List)
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooksServ();
    }

    //Get Book by id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id)
    {
        return ResponseEntity.ok(bookService.getBookByIdServ(id));
    }

    //Update Book by id
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails){


        return  ResponseEntity.ok(bookService.updateBookServ(id, bookDetails));
    }

    //Delete Book by id
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id){

        return  ResponseEntity.ok(bookService.deleteBookServ(id));
    }

}