package book.library.web;

import book.library.exceptions.ResourceNotFoundException;
import book.library.models.Book;
import book.library.models.BookComment;
import book.library.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    //get All Book Comments (List) /REST API
    @GetMapping("/comments")
    public List<BookComment> getAllComments(){
        return commentRepository.findAll();
    }

    //Get all Comments of a book by id /REST API
    @GetMapping("/comments/{id}")
    public List<BookComment> getCommentsByBookId(@PathVariable long id)
    {
        List<BookComment> allBookComments = commentRepository.findAll();
        return allBookComments.stream().filter(bookComment -> id==bookComment.getCommentBookId()).collect(Collectors.toList());
    }

    //Get a Book Comment by id /REST API
    @GetMapping("/comments/{id}/{commentId}")
    public ResponseEntity<BookComment> getCommentById(@PathVariable long id, @PathVariable long commentId)
    {
        List<BookComment> allBookComments = commentRepository.findAll();
        List<BookComment> bookCommentsOfBookId = allBookComments.stream().filter(comm -> id==comm.getCommentBookId()).collect(Collectors.toList());

        BookComment bookComment = bookCommentsOfBookId.stream().filter(comm -> commentId==comm.getCommentId()).findAny()
                .orElseThrow(() -> new ResourceNotFoundException("Comment does not exist with id : " + commentId));

        return  ResponseEntity.ok(bookComment);
    }

    //Create Book Comment /REST API
    @PostMapping("/comments/{id}")
    public BookComment createComment(@PathVariable long id,@RequestBody BookComment bookComment){
        return commentRepository.save(bookComment);
    }
}
