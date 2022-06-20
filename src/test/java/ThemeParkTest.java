import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    ParkingSpot parkingSpot;
    TobaccoStall tobaccoStall;
    Visitor visitor1;


    @Before
    public void before(){
        tobaccoStall = new TobaccoStall("Tobacco Stall", "Timmy Tingles", ParkingSpot.A1, 3);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 3);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 3);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        playground = new Playground("Fun Zone", 7);
        park = new Park("Leafy Meadows", 9);
        dodgems = new Dodgems("Bumper Cars", 5);

        attractions = new ArrayList<Attraction>();
        attractions.add(rollerCoaster);
        attractions.add(playground);
        attractions.add(park);
        attractions.add(dodgems);

        stalls = new ArrayList<Stall>();
        stalls.add(tobaccoStall);
        stalls.add(iceCreamStall);
        stalls.add(candyflossStall);

        themePark = new ThemePark(attractions, stalls);

        visitor1 = new Visitor(10, 1.0, 15.00);
    }

    @Test
    public void hasAttractions(){
        assertEquals(4, themePark.numberOfAttractions());
    }

    @Test
    public void hasStalls(){
        assertEquals(3, themePark.numberOfStalls());
    }

    @Test
    public void returnAllIReviewedObjects(){
        assertEquals(7, themePark.getAllReviewed().size());

    }

    @Test
    public void visitorCanVisitAttraction(){
        themePark.visit(visitor1, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(1, visitor1.getNumberOfAttractions());
    }

    @Test
    public void canReturnHashMapOfReviews(){
        assertEquals(7, themePark.allReviews().size());
    }

    @Test
    public void canGetListOfAllowedLocationsForVisitor(){
        assertEquals(5, themePark.getAllAllowedFor(visitor1).size());
    }

}
