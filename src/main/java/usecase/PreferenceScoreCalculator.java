package usecase;

import java.util.List;

/**
 * This class is intended to help PreferenceFinder
 * by comparing the InterestRank and return the score of each user
 * based on how matched two users are
 */
public class PreferenceScoreCalculator implements ScoreCalculator{
    Integer score;
    //TODO: fetch with user
    List<String> testMainUserInterestRank;

    public PreferenceScoreCalculator(UserForTest otherUser,
                                     List<String> testMainUserInterestRank){
        this.testMainUserInterestRank = testMainUserInterestRank;
        int resScore = 0;//to record the score of the users
        int sameCount = 0; //to record the number of spot that are the same for both users
        for (int i = 0; i < otherUser.getInterestRank().size(); i++){
            //the size should be 6
            String otherUserInterest = otherUser.getInterestRank().get(i);
            String mainUserInterest = this.testMainUserInterestRank.get(i);
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