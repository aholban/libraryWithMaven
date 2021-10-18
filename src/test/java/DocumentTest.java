import com.softwareinstitute.andreeaholban.Document;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DocumentTest {

    @Test
    public void testSetCitationsNo(){
        Document document = new Document("Abstractive methods of summarization", "Andreea Holban");
        document.setCitationsNumber(5);
        assertEquals(5, document.getCitationsNumber());
    }

    @Test
    public void testSetReferences(){
        List<String> refs = new ArrayList<>();
        refs.add("ref1");
        refs.add("ref2");
        Document document = new Document("Abstractive methods of summarization", "Andreea Holban");
        document.setReferences(refs);
        assertEquals("ref1", document.getReferences().get(0));
        assertEquals("ref2", document.getReferences().get(1));
    }

    @Test
    public void testSetAuthor(){
        Document document = new Document("Abstractive methods of summarization", "Andreea Holban");
        document.setAuthor("Edwin Simpson");
        assertEquals("Edwin Simpson", document.getAuthor());
    }
}
