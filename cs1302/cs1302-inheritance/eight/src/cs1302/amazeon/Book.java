package cs1302.amazeon;
import cs1302.Product;
public class Book extends Product {
    private String author;
    public Book(int id, String author) {
        super(id);
        if (author != null) {
            this.author = author;
        } else {
            throw new NullPointerException("author cannot be null");
        } // if
    } // Book
    public String getAuthor() {
        return author;
    } // getAuthor
} // Book
