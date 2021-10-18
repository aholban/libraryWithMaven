import com.softwareinstitute.andreeaholban.Magazine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class MagazineTest {

    @Test
    public void testSetAuthor(){
        Magazine magazine = new Magazine("Vogue", "unknown");
        magazine.setAuthor("Conde Nast Publications");
        assertEquals("Conde Nast Publications", magazine.getAuthor());
    }
}
