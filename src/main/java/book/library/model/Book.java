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
    public Book(String name, String tag) {
        bookName = name;
        bookTag = tag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return bookName;
    }

    public void setName(String name) {
        bookName = name;
    }

    public String getTag() {
        return bookTag;
    }

    public void setTag(String tag) {
        bookTag = tag;
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
