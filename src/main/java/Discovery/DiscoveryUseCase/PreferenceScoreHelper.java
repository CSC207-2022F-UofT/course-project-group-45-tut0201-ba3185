package Discovery.DiscoveryUseCase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import User.User;

/**
 * This class is intended to help PreferenceFinder
 * To get the highest score from the HashMap and then
 */
public class PreferenceScoreHelper {
    HashMap<User, Integer> scoreStorage;
    ArrayList<Integer> totalScoreList;//to get the all the possible value of score
    ArrayList<User> totalUserList;

    public PreferenceScoreHelper(HashMap<User, Integer> scoreStorage){
        this.scoreStorage = scoreStorage;
        ArrayList<Integer> tempScoreList = new ArrayList<>();
        for (User key:this.scoreStorage.keySet()){
            int tempPoint = this.scoreStorage.get(key);
            if (!tempScoreList.contains(tempPoint)){tempScoreList.add(tempPoint);}
        }
        tempScoreList.sort(Collections.reverseOrder());
        this.totalScoreList = tempScoreList;//now this.totalScoreList is in descending order

        ArrayList<User> tempTotalUserList = new ArrayList<>();
        for (int score: this.totalScoreList){
            for (User key:this.scoreStorage.keySet()){
                if (this.scoreStorage.get(key).equals(score)){tempTotalUserList.add(key);}
            }
        }
        this.totalUserList = tempTotalUserList;
    }

    public ArrayList<User> getList(){
        return this.totalUserList;
    }
}
