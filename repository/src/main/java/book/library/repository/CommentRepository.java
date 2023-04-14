package book.library.repository;

import book.library.models.BookComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<BookComment, Long> {
}
