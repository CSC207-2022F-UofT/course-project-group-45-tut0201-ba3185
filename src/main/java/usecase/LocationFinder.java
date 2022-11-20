package usecase;

import java.util.ArrayList;
import entity.User;
import entity.Users;

import java.util.Collections;
import java.util.HashMap;

public class LocationFinder implements LocationFinderInputBoundary{
    private LocationFinderOutputBoundary presenter;
    //the location of the current user
    ArrayList<Double> userLocation;
    Users users;
    //The current user
    User currentUser;

    //constructor
    public LocationFinder(LocationFinderOutputBoundary presenter){
        this.presenter = presenter;
        users = new Users();
        currentUser = users.getCurrentUser();
        userLocation = currentUser.getLocation();
    }

    GenderFinder temGenderFinder = new GenderFinder();
    ArrayList<User> userList = temGenderFinder.genderSuitFinder;

    //return a sorted list of usernames and their distance.
    public ArrayList<String> getNearbyUser() {
        HashMap<String, Double> UserDistance = new HashMap<>();
        ArrayList<Double> listDistance = new ArrayList<>();
        ArrayList<String> listUsername = new ArrayList<>();
        for(User u:userList){
            double d = distance(userLocation, u.getLocation());
            UserDistance.put(u.getUsername(), d);
            listDistance.add(d);
        }
        Collections.sort(listDistance);
        for (Double d: listDistance){
            for (String u: UserDistance.keySet()){
                if(!listUsername.contains(u) && d.equals(UserDistance.get(u))){
                    listUsername.add(u);
                }
            }
        }
        ArrayList<String> listUserDistance = new ArrayList<>();
        for(String u: listUsername){
            listUserDistance.add(u + ": " + String.format("%.2f", UserDistance.get(u)) + "km");
        }
        return listUserDistance;
        }


    //helper: compute and return the distance (in KM) of two users
    private double distance(ArrayList<Double> v1, ArrayList<Double> v2){
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
        return(c * r);
    }
    public void recommendListGenerator(){

        presenter.displayList(getNearbyUser());
    }

    }
