package cs1302.googol;
import cs1302.amazeon.Book;
public class TechBook extends Book {
    private boolean code;
    public TechBook(int id, String author, boolean code) {
        super(id, author);
        this.code = code;
    } // TechBook

    public String getAuthor() {
        String name = super.getAuthor();
        return name + " [TECH]";
    } // getAuthor

} // TechBook
