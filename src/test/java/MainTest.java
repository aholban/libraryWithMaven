
import com.softwareinstitute.andreeaholban.Book;
import com.softwareinstitute.andreeaholban.LibraryItem;
import com.softwareinstitute.andreeaholban.Main;
import com.softwareinstitute.andreeaholban.Member;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.softwareinstitute.andreeaholban.Main.*;
import static org.junit.Assert.assertEquals;


public class MainTest {
    @Test
    public void testFindMember(){
        Member person = new Member("Andreea Holban", "12345");
        Member person2 = new Member("Henry Barrington", "54321");
        List<Member> members = new ArrayList<>();
        members.add(person);
        members.add(person2);
        Member visitor = findMember(members, "Andreea Holban", "12345");
        assertEquals("Andreea Holban", visitor.getName());
        assertEquals("12345", person.getCardID());
        Member visitor2 = findMember(members, "Alex", "6789");
        assertEquals(null, visitor2);
    }

    @Test
    public void testSetUpCollection(){
        List<LibraryItem> items = new ArrayList<>();
        setupCollection(items);
        assertEquals("Mistborn", items.get(0).getTitle());
    }

    @Test
    public void testRegister(){
        List<Member> members = new ArrayList<>();
        Member visitor = Main.register(members, "Andreea");
        assertEquals("Andreea", members.get(0).getName());
        assertEquals("Andreea", visitor.getName());
    }

    @Test
    public void testAddExistingBook(){
        List<LibraryItem> items = new ArrayList<>();
        setupCollection(items);
        items.get(0).setCopiesAvailable(5);
        addBook(items, "book", "Mistborn", "Brandon Sanderson", "physical", "Fantasy", null);
        assertEquals(6, items.get(0).getCopiesAvailable());
    }

    @Test
    public void testAddNewBook(){
        List<LibraryItem> items = new ArrayList<>();
        setupCollection(items);
        addBook(items, "book", "The Hunger Games", "Suzanne Collins", "physical", "Young Adult", null);
        Member person = new Member("Andreea", "12345");
        List<LibraryItem> itemsFound = person.search(items, "", "Suzanne Collins", "");
        assertEquals("The Hunger Games", itemsFound.get(0).getTitle());
    }

    @Test
    public void testAddDocument(){
        List<LibraryItem> items = new ArrayList<>();
        setupCollection(items);
        addBook(items, "document", "Abstractive summarization methods", "Edwin Simpson", "physical", "Computer Science", null);
        Member person = new Member("Andreea", "12345");
        List<LibraryItem> itemsFound = person.search(items, "Abstractive summarization methods", "", "");
        assertEquals("Abstractive summarization methods", itemsFound.get(0).getTitle());
    }

    @Test
    public void testAddUnrecognizableType(){
        List<LibraryItem> items = new ArrayList<>();
        setupCollection(items);
        addBook(items, "b", "The Hunger Games", "Suzanne Collins", "physical", "Young Adult", null);
        Member person = new Member("Andreea", "12345");
        List<LibraryItem> itemsFound = person.search(items, "", "Suzanne Collins", "");
        assertEquals(Boolean.TRUE, itemsFound.isEmpty());
    }
}
