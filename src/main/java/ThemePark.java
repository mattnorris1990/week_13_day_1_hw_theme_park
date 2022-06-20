import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
    }

    public int numberOfAttractions(){
        return attractions.size();
    }

    public int numberOfStalls(){
        return stalls.size();
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList allReviewed = new ArrayList<IReviewed>();

        for (Attraction attraction : attractions){
            allReviewed.add(attraction);
        }

        for (Stall stall : stalls){
            allReviewed.add(stall);
        }

        return allReviewed;
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.setVisitCount();
        visitor.addAttraction(attraction);
    }

    public HashMap<String, Integer> allReviews (){
        HashMap<String,Integer> allRev = new HashMap<String, Integer>();

        for (IReviewed review : getAllReviewed()){
            allRev.put(review.getName(), review.getRating());
        }
        return allRev;
    }

    // this worked by implementing ISecurity at parent level classes, not sure if that's the correct way to do so.
    public ArrayList<IReviewed> getAllAllowedFor (Visitor visitor){
        ArrayList<IReviewed> visitorList = new ArrayList<>();

        for (Attraction attraction : attractions){
            if (attraction.isAllowedTo(visitor)){
                visitorList.add(attraction);
            }
        }

        for (Stall stall : stalls){
            if (stall.isAllowedTo(visitor)){
                visitorList.add(stall);
            }
        }

        return visitorList;
        }


    }
