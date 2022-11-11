package Discovery.DiscoveryUseCase;
import User.User;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * This class is intended to help PreferenceFinder
 * Access it by its parameter
 */
public class PreferenceFinderHelper {
    private final int INITIAL_SCORE = 6;
    User otherUser;
    Integer score;
    User mainUser = new User();
    ArrayList<String> rankOrder = mainUser.getUserInfo("rankOrder");

    public PreferenceFinderHelper(User otherUser){
        this.otherUser = otherUser;
        int resScore = 0;//to record the score of the users
        int sameCount = 0; //to record the number of spot that are the same for both users
        for (int i = 0; i < otherUser.getUserInfo("rankOrder").size(); i++){
            //the size should be 6
            String otherUserInterest = otherUser.getUserInfo("rankOrder").get(i);
            String mainUserInterest = rankOrder.get(i);
            if (otherUserInterest.equals(mainUserInterest)){
                resScore = resScore + INITIAL_SCORE - i;
                sameCount++;
            }
        }
        if (sameCount > 2){resScore++;}
        this.score = resScore;
    }

    public int getScore(){
        return this.score;
    }
}
