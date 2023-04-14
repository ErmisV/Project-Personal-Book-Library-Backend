package book.library.models;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class BookComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column(name= "comment_Book_Id")
    private long commentBookId;

    @Column(name= "comment_Book_Name")
    private String commentBookName;

    @Column(name = "comment_Book_page")
    private double commentBookPage;

    @Column(name = "comment_text")
    private String commentText;

    public BookComment(){
    }

    public BookComment(long commentBookId, String commentBookName,double commentBookPage, String commentText) {
        super();
        this.commentBookId = commentBookId;
        this.commentBookName = commentBookName;
        this.commentBookPage = commentBookPage;
        this.commentText = commentText;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getCommentBookId() {
        return commentBookId;
    }

    public void setCommentBookId(long commentBookId) {
        this.commentBookId = commentBookId;
    }

    public String getCommentBookName() {
        return commentBookName;
    }

    public void setCommentBookName(String commentBookName) {
        this.commentBookName = commentBookName;
    }

    public double getCommentBookPage() {
        return commentBookPage;
    }

    public void setCommentBookPage(double commentBookPage) {
        this.commentBookPage = commentBookPage;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
