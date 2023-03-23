package book.library.app.model;

import javax.persistence.*;
import java.util.ArrayList;

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

    @Column(name = "book_pages")
    private int bookPages;

    @Column(name = "book_reads")
    private int bookReads;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "boot_Tags")
    public Tags bookTags;
    public Book(){

    }

    public Book(String bookName, String bookAuthor, int bookPages, int bookReads, Tags bookTags) {
        super();
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;
        this.bookReads = bookReads;
        this.bookTags = bookTags;
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

    public String getBookAuthor() {return bookAuthor;}
    public void setBookAuthor(String bookAuthor) {this.bookAuthor = bookAuthor;}


    public int getBookPages() {
        return bookPages;
    }
    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public int getBookReads() {
        return bookReads;
    }

    public void setBookReads(int bookReads) {
        this.bookReads = bookReads;
    }
    public Tags getBookTags() {
        return bookTags;
    }

    public void setBookTags(Tags bookTags) {
        this.bookTags = bookTags;
    }
}

 enum Tags {
     Financial, History, Literature, Philosophy, Psychology, Politics, Science
 }
