package use_case.discovery;

import database.csvManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferenceListHelper {
    //TODO: fetch with users
    UserAccess manager = new csvManager();
    Map<String, Object> cUserSettings = manager.readCurrentUser().getUserSetting();
    List<String> mainInterestRank = (List) cUserSettings.get("interestRank");
    //List<String> mainInterestRank = cUserSettings.getInterestRank();

    List<String> afterGenderInteractor = new GenderInteractor().getList();

    public PreferenceListHelper(){}
    public List<String> getList(){
        Map<String, Integer> scoreStorage = new HashMap<>();
        for (String otherUser: afterGenderInteractor){
            ScoreCalculator scoreCalculator = new PreferenceScoreCalculator(otherUser, mainInterestRank);
            scoreStorage.put(otherUser, scoreCalculator.getScore());
        }
        ScoreHelper tempScoreHelper = new ScoreHelper(scoreStorage);
        return tempScoreHelper.getList();
    }
}
