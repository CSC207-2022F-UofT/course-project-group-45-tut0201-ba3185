package usecase;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetNearbyUserHelper {

    UserForTest currentUser; //The current user of UserForTest
    // List of users after the gender finder
    List<UserForTest> userList = new GenderFinder().getList();
    // List of sorted usernames that needs to be returned
    List<String> usernames;
    // sort the list of usernames
    public GetNearbyUserHelper(){
        currentUser = new TestUser().mainUser;
        Map<String, Integer> UserScore = new HashMap<>();
        List<Integer> listScore = new ArrayList<>();
        List<String> listUsername = new ArrayList<>();
        // location of the current user
        ArrayList<Double> userLocation = currentUser.getLocation();
        List<String> tempUsernameList = new ArrayList<>();
        for (UserForTest u : userList) {
            double d = new DistanceHelper(userLocation, u.getLocation()).getDistance();
            Integer s = new LocationScoreCalculator(d).getScore();
            UserScore.put(u.getUsername(), s);
            listScore.add(s);
            tempUsernameList.add(u.getUsername());
        }
        listScore.sort(Collections.reverseOrder());
        for (Integer s : listScore) {
            for (String u : tempUsernameList) {
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
