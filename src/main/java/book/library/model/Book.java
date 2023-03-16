package book.library.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_tag")
    private String bookTag;

    @Column(name = "book_pages")
    private int bookPages;
    public Book(){

    }
    public Book(String bookName, String bookAuthor, String bookTag, int bookPages) {
        super();
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookTag = bookTag;
        this.bookPages = bookPages;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {this.bookName = bookName;}

    public String getBookTag() {
        return bookTag;
    }
    public void setBookTag(String bookTag) {
        this.bookTag = bookTag;
    }


    public String getBookAuthor() {return bookAuthor;}
    public void setBookAuthor(String bookAuthor) {this.bookAuthor = bookAuthor;}


    public int getBookPages() {
        return bookPages;
    }
    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }


}
