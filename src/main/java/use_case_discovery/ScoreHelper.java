package use_case_discovery;
import entity.User;

import java.util.*;

/**
 * This class is intended to help discoveryInteractors
 * To get the highest score from the HashMap,
 * arranged them in descending order,
 * and return a list of username(String)
 */
/**
 * This class is intended to help PreferenceFinder
 * To get the highest score from the HashMap,
 * arranged them in descending order,
 * and return a list of username(String)
 */
public class ScoreHelper {
    Map<String, Integer> scoreStorage;
    List<Integer> totalScoreList;//to get the all the possible value of score
    List<String> totalUsername;

    /**
     *
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
            for (String key:this.scoreStorage.keySet()){
                if (this.scoreStorage.get(key).equals(score)){resTotalUsername.add(key);}
            }
        }
        this.totalUsername = resTotalUsername;
    }

    public List<String> getList(){
        return this.totalUsername;
    }
}