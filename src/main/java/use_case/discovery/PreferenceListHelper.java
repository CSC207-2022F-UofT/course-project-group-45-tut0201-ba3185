package use_case.discovery;

import User.UserForTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferenceListHelper {
    //TODO: fetch with users
    List<String> testMainUserInterestRank = new TestUser().mainUser.getInterestRank();
    private final List<String> returnUserNames;
    List<UserForTest> afterGenderFinder = new GenderFinder().getList();

    public PreferenceListHelper(){
        Map<UserForTest, Integer> scoreStorage = new HashMap<>();
        for (UserForTest otherUser:afterGenderFinder){
            ScoreCalculator scoreCalculator = new PreferenceScoreCalculator(otherUser, testMainUserInterestRank);
            scoreStorage.put(otherUser, scoreCalculator.getScore());
        }
        ScoreHelper tempPreferenceScoreHelper = new ScoreHelper(scoreStorage);
        this.returnUserNames = tempPreferenceScoreHelper.getList();
    }
    public List<String> getList(){
        return this.returnUserNames;
    }
}
