package book.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_pages")
    private double bookPages;

    @Column(name = "book_reads")
    private double bookReads;

    @Column(name = "book_progress")
    private double bookProgress;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "boot_Tags")
    public Tags bookTags;
    public Book(){

    }

    public Book(String bookName, String bookAuthor, double bookPages, double bookReads, Tags bookTags) {
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

    public double getBookPages() {
        return bookPages;
    }
    public void setBookPages(double bookPages) {
        this.bookPages = bookPages;
    }

    public double getBookReads() {
        return bookReads;
    }

    public void setBookReads(double bookReads) {
        this.bookReads = bookReads;
    }

    public double getBookProgress() {
        return Math.round((this.bookReads/this.bookPages)*100);
    }
    public void setBookProgress(double bookProgress) {
        this.bookProgress = bookProgress;
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
