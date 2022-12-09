package use_case.discovery;

import database.csvInterface;
import database.csvManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PreferenceListHelper is to return a list of usernames.
 * The users in the list are those who share the most similarity with the current user in terms of "interestRank"
 * "interestRank" is a variable of a list that contains six strings: "income", "pet",
 * "marital status", "relationship type", "interests", "age".
 * String put at the front of rank is the aspect that current user cares the most;
 * String put at the end is the aspect that current user cares the least.
 */
public class PreferenceListHelper {
    csvInterface manager = new csvManager();
    List<String> cInterestRank = manager.readCurrentUser().getInterestRank();
    List<String> afterGenderInteractor = new GenderInteractor().getList();

    public PreferenceListHelper(){}
    public List<String> getList(){
        Map<String, Integer> scoreStorage = new HashMap<>();
        for (String otherUser: afterGenderInteractor){
            ScoreCalculator scoreCalculator = new PreferenceScoreCalculator(otherUser, cInterestRank);
            scoreStorage.put(otherUser, scoreCalculator.getScore());
        }
        ScoreHelper tempScoreHelper = new ScoreHelper(scoreStorage);
        return tempScoreHelper.getList();
    }
}
