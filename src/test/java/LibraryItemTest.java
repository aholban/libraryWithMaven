import com.softwareinstitute.andreeaholban.Book;
import com.softwareinstitute.andreeaholban.Document;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class LibraryItemTest {

    @Test
    public void testSetTitle(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        book.setTitle("Emma");
        Document document = new Document("", "", null, "", Boolean.TRUE, "", "", 1, 1, 0, null);
        document.setTitle("Automatic summarization");
        assertEquals("Emma", book.getTitle());
        assertEquals("Automatic summarization", document.getTitle());
    }

    @Test
    public void testSetPublicationDate(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        book.setPublicationDate(LocalDate.of(2017, 7, 5));
        assertEquals(LocalDate.of(2017, 7, 5), book.getPublicationDate());
    }

    @Test
    public void testSetISBN(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        book.setISBN("12345");
        assertEquals("12345", book.getISBN());
    }

    @Test
    public void testSetBorrowable(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        book.setBorrowable(Boolean.FALSE);
        assertEquals(Boolean.FALSE, book.getBorrowable());
    }

    @Test
    public void testSetFormat(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        book.setFormat("digital");
        assertEquals("digital", book.getFormat());
    }

    @Test
    public void testSetSection(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        book.setSection("Romance");
        assertEquals("Romance", book.getSection());
    }

    @Test
    public void testSetShelf(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        book.setShelf(4);
        assertEquals(4, book.getShelf());
    }


}
