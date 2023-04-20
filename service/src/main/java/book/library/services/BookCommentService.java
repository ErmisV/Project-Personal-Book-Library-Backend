package book.library.services;

import book.library.models.BookComment;

import java.util.List;
import java.util.Map;

public interface BookCommentService {

    BookComment updateCommentServ(Long commentId, BookComment bookCommentDetails);

    Map<String, Boolean> deleteCommentServ(Long id, Long commentId);

    List<BookComment> getAllCommentsServ();
    List<BookComment> getAllCommentsServ(Long id);

    BookComment getCommentByIdServ(Long id,Long commentId);

    BookComment createCommentServ(BookComment bookComment);

}
