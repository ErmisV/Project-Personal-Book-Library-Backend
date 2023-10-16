package book.library.services;

import book.library.exceptions.ResourceNotFoundException;
import book.library.entity.BookComment;
import book.library.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookCommentServiceImp implements BookCommentService {

    private CommentRepository commentRepository;

    @Autowired
    public BookCommentServiceImp(CommentRepository commentRepository) {
        super();
        this.commentRepository = commentRepository;
    }

    @Override
    public BookComment updateCommentServ(Long commentId, BookComment bookCommentDetails) {

        BookComment bookComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment does not exist with id : " + commentId));

        bookCommentDetails.setCommentBookId(bookCommentDetails.getCommentBookId());
        bookCommentDetails.setCommentBookName(bookCommentDetails.getCommentBookName());
        bookCommentDetails.setCommentBookPage(bookCommentDetails.getCommentBookPage());
        bookCommentDetails.setCommentText(bookCommentDetails.getCommentText());

        return commentRepository.save(bookComment);
    }

    @Override
    public Map<String, Boolean> deleteCommentServ (Long id, Long commentId) {
        BookComment bookComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment does not exist with id:" + commentId));
        commentRepository.delete(bookComment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public List<BookComment> getAllCommentsServ (){
        return commentRepository.findAll();
    }

    @Override
    public List<BookComment> getAllCommentsServ (Long id) {

        List<BookComment> allBookComments = commentRepository.findAll();
        return allBookComments.stream().filter(bookComment -> id == bookComment.getCommentBookId()).collect(Collectors.toList());
    }

    @Override
    public BookComment getCommentByIdServ(Long id,Long commentId){
    List<BookComment> allBookComments = commentRepository.findAll();
    List<BookComment> bookCommentsOfBookId = allBookComments.stream().filter(comm -> id==comm.getCommentBookId()).collect(Collectors.toList());

    BookComment bookComment = bookCommentsOfBookId.stream().filter(comm -> commentId==comm.getCommentId()).findAny()
            .orElseThrow(() -> new ResourceNotFoundException("Comment does not exist with id : " + commentId));
    return bookComment;
    }


    @Override
    public BookComment createCommentServ(BookComment bookComment) {
        return commentRepository.save(bookComment);
    }
}
