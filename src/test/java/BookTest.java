import com.softwareinstitute.andreeaholban.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {
    @Test
    public void testGetTitle(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        assertEquals( "Pride and Prejudice", book.getTitle());
    }

    @Test
    public void testGetAuthor(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        assertEquals( "Jane Austen", book.getAuthor());
    }

    @Test
    public void testSetAuthor(){
        Book book = new Book("Pride and Prejudice", "JK Rowling", Boolean.TRUE, "available");
        book.setAuthor("Jane Austen");
        assertEquals( "Jane Austen", book.getAuthor());
    }

    @Test
    public void testGetStatus(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "available");
        assertEquals("available", book.getStatus());
    }

    @Test
    public void testSetStatus(){
        Book book = new Book("Pride and Prejudice", "Jane Austen", Boolean.TRUE, "unavailable");
        book.setStatus("available");
        assertEquals("available", book.getStatus());
    }

}
