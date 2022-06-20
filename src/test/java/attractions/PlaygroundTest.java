package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void canOnlyVisitIf15orUnder(){
        Visitor visitor1 = new Visitor(10, 100, 15);
        Visitor visitor2 = new Visitor(16, 100, 15);
        assertEquals(true, playground.isAllowedTo(visitor1));
        assertEquals(false, playground.isAllowedTo(visitor2));
    }
}
