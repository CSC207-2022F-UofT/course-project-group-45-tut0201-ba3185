package use_case.discovery;

import java.util.List;
/**
 * PreferenceScoreCalculator is a helper class of PreferenceListHelper
 * The class compares the variable "interestRank" between current user and a given other user,
 * and returns the score of the given other user
 * The score is calculated based on the position and the number of matches, it follows the algorithm below:
 * If both "interestRank" matches at index 0, 6 points is added;
 * if both "interestRank" matches at index 1, 5 points is added;
 * if both "interestRank" matches at index 2, 4 points is added...
 * In addition, if there are more than 2 matches(regardless the index position), an extra point will be added
 */
public class PreferenceScoreCalculator extends ParentClass implements ScoreCalculator{
    private final static int INTEREST_RANK = 6;
    List<String> cInterestRank;
    String oName;

    /**
     * @param oName is the provided name of other user
     * @param cInterestRank is the list of interest rank from the current user
     */
    public PreferenceScoreCalculator(String oName, List<String> cInterestRank){
        this.cInterestRank = cInterestRank;
        this.oName = oName;
    }
    public int getScore(){
        int resScore = 0;//to record the score of the users
        int sameCount = 0; //to record the number of spot that are the same for both users
        for (int i = 0; i < INTEREST_RANK; i++){
            List<String> oInterestRankList = super.otherUsersInfo.get(this.oName).getInterestRank();
            String oInterestRank = oInterestRankList.get(i);
            String cInterestRank = this.cInterestRank.get(i);
            if (oInterestRank.equals(cInterestRank)){
                int INITIAL_SCORE = 6;
                resScore = resScore + INITIAL_SCORE - i;
                sameCount++;
            }
        }
        if (sameCount > 2){resScore++;}
//        this.score = resScore;
        return resScore;
    }
}
