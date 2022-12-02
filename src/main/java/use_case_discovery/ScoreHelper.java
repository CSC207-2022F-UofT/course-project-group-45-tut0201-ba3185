package use_case_discovery;
import entity.User;

import java.util.*;

/**
 * This class is intended to help PreferenceFinder
 * To get the highest score from the HashMap,
 * arranged them in descending order,
 * and return a list of username(String)
 */
public class ScoreHelper {
    Map<User, Integer> scoreStorage;
    List<Integer> totalScoreList;//to get the all the possible value of score
    List<String> totalUsername;


    public ScoreHelper(Map<User, Integer> scoreStorage){
        this.scoreStorage = scoreStorage;
        this.scoreStorage = scoreStorage;
        List<Integer> tempScoreList = new ArrayList<>();
        for (User key:this.scoreStorage.keySet()){
            int tempPoint = this.scoreStorage.get(key);
            if (!tempScoreList.contains(tempPoint)){tempScoreList.add(tempPoint);}
        }
        tempScoreList.sort(Collections.reverseOrder());
        this.totalScoreList = tempScoreList;//now this.totalScoreList is in descending order

        List<String> resTotalUsername = new ArrayList<>();
        for (int score: this.totalScoreList){
            for (User key:this.scoreStorage.keySet()){
                if (this.scoreStorage.get(key).equals(score)){resTotalUsername.add(key.getUsername());}
            }
        }
        this.totalUsername = resTotalUsername;
    }

    public List<String> getList(){
        return this.totalUsername;
    }

}
