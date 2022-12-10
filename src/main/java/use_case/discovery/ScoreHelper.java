package use_case.discovery;

import java.util.*;

/**
 * ScoreHelper is to help PreferenceListHelper by arranging users in descending order based on their scores.
 * If multiple users have the same score, their names are arranged in alphabet order.
 * A list of usernames is returned.
 */
public class ScoreHelper {
    Map<String, Integer> scoreStorage;
    List<Integer> totalScoreList;
    List<String> totalUsername;

    /**
     * @param scoreStorage stores the information of user with his/hers score
     */

    public ScoreHelper(Map<String, Integer> scoreStorage){
        this.scoreStorage = scoreStorage;
        List<Integer> tempScoreList = new ArrayList<>();
        for (String key:this.scoreStorage.keySet()){
            int tempPoint = this.scoreStorage.get(key);
            if (!tempScoreList.contains(tempPoint)){tempScoreList.add(tempPoint);}
        }
        tempScoreList.sort(Collections.reverseOrder());
        this.totalScoreList = tempScoreList;//now this.totalScoreList is in descending order

        List<String> resTotalUsername = new ArrayList<>();
        for (int score: this.totalScoreList){
            List<String> subRes = new ArrayList<>();
            for (String userName:this.scoreStorage.keySet()){
                if (this.scoreStorage.get(userName).equals(score)){subRes.add(userName);}
            }
            Collections.sort(subRes);
            resTotalUsername.addAll(subRes);
        }
        this.totalUsername = resTotalUsername;
    }

    public List<String> getList(){

        return this.totalUsername;
    }
}
