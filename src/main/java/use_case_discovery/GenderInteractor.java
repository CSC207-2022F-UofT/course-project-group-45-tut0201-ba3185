package use_case_discovery;
import database.csvInterface;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * GenderFinder takes user's sexual orientation and filter other users based
 * Documentary of possible sexual orientation:
 *(possible sexual orientation): (return from GenderFinder)
 * male: return only users identified themselves as male
 * female: return only users identified themselves as female
 * bisexual: return only users identified themselves as both male and female
 */

public class GenderInteractor extends ParentClass{
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