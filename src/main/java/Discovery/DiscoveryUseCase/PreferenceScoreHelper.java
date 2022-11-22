package Discovery.DiscoveryUseCase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import User.UserForTest;

/**
 * This class is intended to help PreferenceFinder
 * To get the highest score from the HashMap,
 * arranged them in descending order,
 * and return a list of username(String)
 */
public class PreferenceScoreHelper {
    HashMap<UserForTest, Integer> scoreStorage;
    ArrayList<Integer> totalScoreList;//to get the all the possible value of score
    ArrayList<String> totalUsername;

    /**
     *
     * @param scoreStorage stores the information of user with his/hers score
     */

    public PreferenceScoreHelper(HashMap<UserForTest, Integer> scoreStorage){
        this.scoreStorage = scoreStorage;
        ArrayList<Integer> tempScoreList = new ArrayList<>();
        for (UserForTest key:this.scoreStorage.keySet()){
            int tempPoint = this.scoreStorage.get(key);
            if (!tempScoreList.contains(tempPoint)){tempScoreList.add(tempPoint);}
        }
        tempScoreList.sort(Collections.reverseOrder());
        this.totalScoreList = tempScoreList;//now this.totalScoreList is in descending order

        ArrayList<String> resTotalUsername = new ArrayList<>();
        for (int score: this.totalScoreList){
            for (UserForTest key:this.scoreStorage.keySet()){
                if (this.scoreStorage.get(key).equals(score)){resTotalUsername.add((String)key.getUsername());}
            }
        }
        this.totalUsername = resTotalUsername;
    }

    public ArrayList<String> getList(){
        return this.totalUsername;
    }
}
