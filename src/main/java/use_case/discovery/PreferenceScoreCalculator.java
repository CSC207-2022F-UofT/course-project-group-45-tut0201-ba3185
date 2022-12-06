package use_case.discovery;
import database.csvManager;
import use_case.signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static use_case.discovery.GenderInteractor.USER_SETTING;

/**
 * This class is intended to help PreferenceFinder
 * by comparing the InterestRank and return the score of each user
 * based on how matched two users are
 */
public class PreferenceScoreCalculator implements ScoreCalculator{
    private final static int INTEREST_RANK = 6;
    Integer score;
    List<String> mainInterestRank;
    //fetched with user 1205
    UserAccess manager = new csvManager();
    Map<String, UserRequestModel> otherUsers;
    String otherUserName;

    /**
     *
     * @param otherUserName is the provided name of other user
     * @param mainInterestRank is the list of interest rank from the current user
     */
    public PreferenceScoreCalculator(String otherUserName, List<String> mainInterestRank){
        this.mainInterestRank = mainInterestRank;
        this.otherUserName = otherUserName;
        try{
            this.otherUsers = manager.readUser();
        }
        catch (IOException exception){
            throw new RuntimeException(exception);
        };
    }

    public int getScore(){
        int resScore = 0;//to record the score of the users
        int sameCount = 0; //to record the number of spot that are the same for both users
        for (int i = 0; i < INTEREST_RANK; i++){
            Map<String, Object> oUser = this.otherUsers.get(this.otherUserName).getUserSetting();
            List<String> oInterestRank = (List<String>)oUser.get("interestRank");
            //List<String> oInterestRank = oUser.getInterestRank();
            String otherUserInterest = oInterestRank.get(i);
            String mainUserInterest = this.mainInterestRank.get(i);
            if (otherUserInterest.equals(mainUserInterest)){
                int INITIAL_SCORE = 6;
                resScore = resScore + INITIAL_SCORE - i;
                sameCount++;
            }
        }
        if (sameCount > 2){resScore++;}
        this.score = resScore;
        return this.score;
    }
}
