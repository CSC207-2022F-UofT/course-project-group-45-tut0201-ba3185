package use_case_discovery;
import entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This class is intended to help PreferenceFinder
 * To get the highest score from the HashMap,
 * arranged them in descending order,
 * and return a list of username(String)
 */
public class PreferenceScoreHelper {
    HashMap<User, Integer> scoreStorage;
    ArrayList<Integer> totalScoreList;//to get the all the possible value of score
    ArrayList<String> totalUsername;

    public PreferenceScoreHelper(HashMap<User, Integer> scoreStorage){
        this.scoreStorage = scoreStorage;
        ArrayList<Integer> tempScoreList = new ArrayList<>();
        for (User key:this.scoreStorage.keySet()){
            int tempPoint = this.scoreStorage.get(key);
            if (!tempScoreList.contains(tempPoint)){tempScoreList.add(tempPoint);}
        }
        tempScoreList.sort(Collections.reverseOrder());
        this.totalScoreList = tempScoreList;//now this.totalScoreList is in descending order

        ArrayList<String> resTotalUsername = new ArrayList<>();
        for (int score: this.totalScoreList){
            for (User key:this.scoreStorage.keySet()){
                if (this.scoreStorage.get(key).equals(score)){resTotalUsername.add((String)key.getUserInfo("Username"));}
            }
        }
        this.totalUsername = resTotalUsername;
    }

    public ArrayList<String> getList(){
        return this.totalUsername;
    }
}
