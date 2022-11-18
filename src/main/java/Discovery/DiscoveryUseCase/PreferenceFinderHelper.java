package Discovery.DiscoveryUseCase;
import User.User;
import User.Users;

import java.util.ArrayList;

/**
 * This class is intended to help PreferenceFinder
 * Access it by its parameter
 */
public class PreferenceFinderHelper {
    Integer score;
    User mainUser = Users.getCurrentUser();
    ArrayList<String> mainUserRankOrder = mainUser.getInterestRank();

    public PreferenceFinderHelper(User otherUser){
        int resScore = 0;//to record the score of the users
        int sameCount = 0; //to record the number of spot that are the same for both users
        for (int i = 0; i < otherUser.getInterestRank().size(); i++){
            //the size should be 6
            String otherUserInterest = otherUser.getInterestRank().get(i);
            String mainUserInterest = mainUserRankOrder.get(i);
            if (otherUserInterest.equals(mainUserInterest)){
                int INITIAL_SCORE = 6;
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
