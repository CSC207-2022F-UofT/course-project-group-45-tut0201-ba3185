package use_case_discovery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.discovery.DistanceHelper;
import use_case.discovery.LocationScoreCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * This is used to test the returned score if given two locations
 * And need to compute the distance at first
 */
public class NearbyScoreTest {

    @Test
    public void case1(){
        //I want to set the loc1 as BA, and loc2 as UofT Bookstore
        // and the location of BA is  -79.39690713639136, 43.65976899879969
        // the location of bookstore is  -79.39720282403519, 43.65891332936174
        List<Double> loc1 = new ArrayList<>();
        List<Double> loc2 = new ArrayList<>();
        loc1.add(-79.39690713639136);
        loc1.add(43.65976899879969);
        loc2.add(-79.39720282403519);
        loc2.add(43.65891332936174);

        Double d = new DistanceHelper(loc1, loc2).getDistance();
        Integer s = new LocationScoreCalculator(d).getScore();
        Assertions.assertEquals(40, s);
    }

    @Test
    public void case2(){
        //I want to set the loc3 as BA, and loc4 as Bayview Shopping Centre
        //The location of shopping centre is  -79.38521257327263, 43.76847774745433
        List<Double> loc3 = new ArrayList<>();
        List<Double> loc4 = new ArrayList<>();
        loc3.add(-79.39690713639136);
        loc3.add(43.65976899879969);
        loc4.add(-79.38521257327263);
        loc4.add(43.76847774745433);

        Double d = new DistanceHelper(loc3, loc4).getDistance();
        Integer s = new LocationScoreCalculator(d).getScore();
        Assertions.assertEquals(10, s);
    }
}
