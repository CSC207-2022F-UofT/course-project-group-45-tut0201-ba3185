package Discovery.DiscoveryUseCase;
import User.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * PreferenceFinder help find other users that also rank the characteristics in a close way
 * 1. rankOrder ranks the characteristics from 1 to 6, where 1 is the most important and 6 is the least
 * for each characteristic that matches on the same rank order, a default point is added
 * i.e. first position the same, 6 points added; and the point descends as rank order increasing
 * 2. there's a bonus one-point mark to add for the user that has more than 2 same spots
 * and filter other users based on this order(i.e.)
 * default is to display 15 users everytime
 */
public class PreferenceFinder implements PreferenceFinderInputBoundary{


    private DiscoveryListOutputBoundary presenter;//this is for returning the list
    private ArrayList<User> preferenceList;

    GenderFinder tempGenderFinder = new GenderFinder();
    ArrayList<User> afterGenderFinder = tempGenderFinder.getList();

    public PreferenceFinder(DiscoveryListOutputBoundary presenter){
        this.presenter = presenter;
    }

    public ArrayList<User> getList(){
        HashMap<User, Integer> scoreStorage = new HashMap<>();
        for (User otherUser:afterGenderFinder){
            PreferenceFinderHelper temp = new PreferenceFinderHelper(otherUser);
            scoreStorage.put(otherUser, temp.getScore());
        }
        //the list of username after arranged by score from high to low
        PreferenceScoreHelper temp = new PreferenceScoreHelper(scoreStorage);

        return temp.getList();
    }

    public void recommendListGenerator(){
        presenter.displayList(0,getList());
    }

}
