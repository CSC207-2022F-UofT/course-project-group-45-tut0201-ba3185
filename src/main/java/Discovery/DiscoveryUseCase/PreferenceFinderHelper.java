package Discovery.DiscoveryUseCase;
import User.UserPreference;
import User.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is intended to help PreferenceFinder
 * Access it by its parameter
 */
public class PreferenceFinderHelper {
    User otherUser;
    //String userIdentify;
    Integer score;
    User mainUser = new User();
    ArrayList<String> rankOrder = mainUser.getUserInfo("rankOrder");


    public PreferenceFinderHelper(User otherUser){
        //this.userIdentify = otherUser.getUserName();
        this.otherUser = otherUser;
        int initialScore = 6;
        int resScore = 0;//to record the score of the users
        int sameCount = 0; //to record the number of spot that are the same for both users
        //assume the rankOrder is stored in user class
        for (int i = 0; i < otherUser.getUserInfo("rankOrder").size(); i++){
            //the size should be 6
            String otherUserInterest = otherUser.getUserInfo("rankOrder").get(i);
            String mainUserInterest = rankOrder.get(i);
            if (otherUserInterest.equals(mainUserInterest)){
                resScore = resScore + initialScore - i;
                sameCount++;
            }
        }
        if (sameCount > 2){resScore++;}
        this.score = resScore;
    }

    public int getScore(){
        return this.score;
    }

    /*public ArrayList<User> getHobbyList(String Hobby,
                                        ArrayList<User> afterGenderFinder) {
        ArrayList<User> res = new ArrayList<User>();
        //case that fits the preference in first rank
        for (User otherUser : afterGenderFinder) {
            // ##user.getHobby return a HashMap that keys are String and values are Object
            if (otherUser.getHobby().get(Hobby).equals(interest_list.get(Hobby))) {
                res.add(otherUser);
            }

        }
        return res;
    }*/
}
