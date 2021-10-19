import com.softwareinstitute.andreeaholban.Book;
import com.softwareinstitute.andreeaholban.LibraryItem;
import com.softwareinstitute.andreeaholban.Main;
import com.softwareinstitute.andreeaholban.Member;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class SearchableTest {

    @Test
    public void testSearch(){
        Member person = new Member("Andreea", "12345");
        List<LibraryItem> items = new ArrayList<>();
        Main.setupCollection(items);
        List<LibraryItem> itemsFound = person.search(items, "Mistborn", "", "");
        assertEquals(items.get(0), itemsFound.get(0));
        itemsFound = person.search(items, "Mistborn", "Brandon Sanderson", "");
        assertEquals(items.get(0), itemsFound.get(0));
        itemsFound = person.search(items,"", "Brandon Sanderson", "");
        assertEquals(items.get(0), itemsFound.get(0));
        itemsFound = person.search(items, "", "", "Fantasy");
        assertEquals(items.get(0), itemsFound.get(0));
        assertEquals(items.get(1), itemsFound.get(1));
        itemsFound = person.search(items, "", "", "");
        assertEquals(Boolean.TRUE, itemsFound.isEmpty());

    }
}
