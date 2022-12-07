package use_case.discovery;

import database.csvInterface;
import database.csvManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * GenderInteractor takes current user's sexual orientation and filter out other users that do not satisfy the condition
 * Documentary of sexual orientation:
 * male: return only users identified themselves as male
 * female: return only users identified themselves as female
 * bisexual: return all users
 */

public class GenderInteractor extends csvInteractor {
    csvInterface manager = new csvManager();
    String cSexualOrientation = (String)manager.readCurrentUser().getUserSetting().get("sexualOrientation");

    public GenderInteractor(){}
    public List<String> getList(){
        List<String> resUserNames = new ArrayList<>();
        //the case of male or female
        if (cSexualOrientation.equals("male")||
                cSexualOrientation.equals("female")){
            for (String key:super.otherUsersInfo.keySet()){
                Map<String, Object> user = super.otherUsersInfo.get(key).getUserSetting();
                if ((user.get("gender")).equals(cSexualOrientation)){
                    resUserNames.add(key);
                }
            }
        }
        //the case of Bisexual
        if (cSexualOrientation.equals("bisexual")){
            resUserNames.addAll(super.otherUsersInfo.keySet());
        }
        return resUserNames;
    }
}



