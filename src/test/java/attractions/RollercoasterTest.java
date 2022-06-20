package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(10, 1.0, 15.00);
        visitor2 = new Visitor(16, 1.1, 15.00);
        visitor3 = new Visitor(10, 1.5, 15.00);
        visitor4 = new Visitor(13, 2.1, 15.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canOnlyVisitIf145cmAnd12(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
        assertEquals(true, rollerCoaster.isAllowedTo(visitor4));
    }

    @Test
    public void returnsDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.00);
    }

    @Test
    public void calculatesPriceIfUnder200cm(){
        assertEquals(8.40, rollerCoaster.priceFor(visitor1), 0.00);
    }

    @Test
    public void calculatesPriceIfOver200cm(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor4), 0.00);
    }

}
