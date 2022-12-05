package use_case_discovery;
import entity.User;

import java.util.*;

/**
 * This class is intended to help discoveryInteractors
 * To get the highest score from the HashMap,
 * arranged them in descending order,
 * and return a list of username(String)
 */
public class ScoreHelper {
    Map<UserForTest, Integer> scoreStorage;
    List<Integer> totalScoreList;//to get the all the possible value of score
    List<String> totalUsername;


    public ScoreHelper(Map<UserForTest, Integer> scoreStorage){
        this.scoreStorage = scoreStorage;
        List<Integer> tempScoreList = new ArrayList<>();
        for (UserForTest key:this.scoreStorage.keySet()){
            int tempPoint = this.scoreStorage.get(key);
            if (!tempScoreList.contains(tempPoint)){tempScoreList.add(tempPoint);}
        }
        tempScoreList.sort(Collections.reverseOrder());
        this.totalScoreList = tempScoreList;// at this step this.totalScoreList is in descending order

        List<String> resTotalUsername = new ArrayList<>();
        for (int score: this.totalScoreList){
            for (UserForTest key:this.scoreStorage.keySet()){
                if (this.scoreStorage.get(key).equals(score)){resTotalUsername.add(key.getUsername());}
            }
        }
        this.totalUsername = resTotalUsername;
    }

    public List<String> getList(){
        return this.totalUsername;
    }

}
