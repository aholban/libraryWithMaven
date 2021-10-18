
import com.softwareinstitute.andreeaholban.LibraryItem;
import com.softwareinstitute.andreeaholban.Member;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.softwareinstitute.andreeaholban.Main.findMember;
import static com.softwareinstitute.andreeaholban.Main.setupCollection;
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
}
