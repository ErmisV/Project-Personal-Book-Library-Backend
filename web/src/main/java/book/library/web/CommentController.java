package book.library.web;

import book.library.models.BookComment;
import book.library.services.BookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2")
public class CommentController {

    @Autowired
    private BookCommentService bookCommentService;

    //get All Book Comments (List) /REST API
    @GetMapping("/comments")
    public List<BookComment> getAllComments(){
        return bookCommentService.getAllCommentsServ();
    }

    //Get all Comments of a book by id /REST API
    @GetMapping("/comments/{id}")
    public List<BookComment> getCommentsByBookId(@PathVariable long id){
        return bookCommentService.getAllCommentsServ(id);
    }

    //Get a Book Comment by id /REST API
    @GetMapping("/comments/{id}/{commentId}")
    public ResponseEntity<BookComment> getCommentById(@PathVariable long id, @PathVariable long commentId) {
        return  ResponseEntity.ok(bookCommentService.getCommentByIdServ(id,commentId));
    }

    //Create Book Comment /REST API
    @PostMapping("/comments/{id}")
    public BookComment createComment(@PathVariable long id,@RequestBody BookComment bookComment){
        return bookCommentService.createCommentServ(bookComment);
    }

    @PutMapping("/books/{id}/{commentId}")
    public ResponseEntity<BookComment> updateComment(@PathVariable Long id,@PathVariable Long commentId, @RequestBody BookComment bookCommentDetails){
        return  ResponseEntity.ok( bookCommentService.updateCommentServ(commentId,bookCommentDetails));
    }

    @DeleteMapping("/books/{id}/{commentId}")
    public ResponseEntity<Map<String, Boolean>> deleteComment(@PathVariable Long id,@PathVariable Long commentId){
        return  ResponseEntity.ok(bookCommentService.deleteCommentServ(id,commentId));
    }
}
