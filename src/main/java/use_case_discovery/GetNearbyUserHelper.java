package use_case_discovery;


import database.csvInterface;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to get the current user's location and list of usernames that filtered by genderInteractor
 * And then sort the list based on score calculated by LocationScoreCalculator
 */
public class GetNearbyUserHelper {

    // List of usernames after the gender finder
    List<String> userList = new GenderInteractor().getList();
    // List of sorted usernames that needs to be returned
    List<String> usernames;
    // A map consists of all Users
    Map<String, UserRequestModel> allUser;
    public GetNearbyUserHelper() {
        csvInterface manager = new csvManager();
        // get location of the current user
        List<Double> UserLocation = manager.readCurrentUser().getLocation();
        // A map consists of all users
        try{
            this.allUser = manager.readUser();
        }
        catch (IOException exception){
            throw new RuntimeException(exception);
        }
        // A map used to store each username with their corresponding score.
        Map<String, Integer> UserScore = new HashMap<>();
        // a list of scores that used to sort
        List<Integer> listScore = new ArrayList<>();
        List<String> listUsername = new ArrayList<>();
        for(String username : userList) {
            UserRequestModel requestModel = allUser.get(username);
            List<Double> tempLocation = requestModel.getLocation();
            double d = new DistanceHelper(UserLocation, tempLocation).getDistance();
            Integer s = new LocationScoreCalculator(d).getScore();
            UserScore.put(username, s);
            listScore.add(s);
        }
        listScore.sort(Collections.reverseOrder());
        for (Integer s : listScore) {
            for (String u : userList) {
                if (!listUsername.contains(u) && s.equals(UserScore.get(u))) {
                    listUsername.add(u);
                }
            }
        }
        this.usernames = listUsername;
    }

    //return a sorted list of usernames based on their distance.
    public List<String> getList() {

        return usernames;
    }
    }