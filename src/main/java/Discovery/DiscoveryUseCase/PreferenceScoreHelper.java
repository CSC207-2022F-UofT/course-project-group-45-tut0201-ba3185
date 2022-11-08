package Discovery.DiscoveryUseCase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This class is intended to help PreferenceFinder
 * To get the highest score from the HashMap and then
 */
public class PreferenceScoreHelper {
    HashMap<String, Integer> scoreStorage;
    //to get the all the value
    ArrayList<Integer> totalScoreList;
    ArrayList<String> totalUserNameList;

    public PreferenceScoreHelper(HashMap<String, Integer> scoreStorage){
        this.scoreStorage = scoreStorage;
        ArrayList<Integer> tempScoreList = new ArrayList<>();
        for (String key:this.scoreStorage.keySet()){
            int tempPoint = this.scoreStorage.get(key);
            if (!tempScoreList.contains(tempPoint)){tempScoreList.add(tempPoint);}
        }
        tempScoreList.sort(Collections.reverseOrder());
        this.totalScoreList = tempScoreList;//now totalScoreList is in descending order

        ArrayList<String> tempUserNameList = new ArrayList<>();
        for (int score: this.totalScoreList){
            for (String key:this.scoreStorage.keySet()){
                if (this.scoreStorage.get(key).equals(score)){tempUserNameList.add(key);}
            }
        }
        this.totalUserNameList = tempUserNameList;
    }


}
