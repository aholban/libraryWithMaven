import com.softwareinstitute.andreeaholban.Blueprint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlueprintTest {

    @Test
    public void testSetAuthor(){
        Blueprint map = new Blueprint("Romania", "Teodora");
        map.setAuthor("Bogdan");
        assertEquals("Bogdan", map.getAuthor());
    }
}
