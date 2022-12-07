package usecase;

import java.util.List;

/**
 * This class is intended to help to calculate the distance
 * given two locations
*/

public class DistanceHelper {

    public final Double distance;
    //v1 and v2 are two locations
    public DistanceHelper(List<Double> v1, List<Double> v2){
        //lon represents longitude, lat represents latitude
        double lon1 = v1.get(0);
        double lat1 = v1.get(1);
        double lon2 = v2.get(0);
        double lat2 = v2.get(1);

        // The math module contains a function
        // named toRadians which converts from degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double d_lon = lon2 - lon1;
        double d_lat = lat2 - lat1;
        double a = Math.pow(Math.sin(d_lat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(d_lon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));
        // Radius of earth in kilometers. Use 395 for miles
        double r = 6371;

        // calculate the result
        distance = (c * r);
    }

    public Double getDistance(){
        return distance;
    }
}
