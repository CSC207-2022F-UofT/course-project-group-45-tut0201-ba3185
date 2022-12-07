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

public class GenderInteractor {
    // fetched with User(1205)
    public static final int USER_SETTING = 4;
    csvInterface manager = new csvManager();
    Map<String, Object> userSettings = manager.readCurrentUser().getUserSetting();
    String mainSexualOrientation = (String)userSettings.get("sexualOrientation");
    Map<String, UserRequestModel> otherUsers;

    public GenderInteractor(){
        try{
            this.otherUsers = manager.readUser();
        }
        catch (IOException exception){
            throw new RuntimeException(exception);
        };
    }
    public List<String> getList(){
        List<String> resUserNames = new ArrayList<>();
        //the case of Male or Female
        if (mainSexualOrientation.equals("male")||
                mainSexualOrientation.equals("female")){
            for (String key:this.otherUsers.keySet()){
                Map<String, Object> user = this.otherUsers.get(key).getUserSetting();
                if ((user.get("gender")).equals(mainSexualOrientation)){
                    resUserNames.add(key);
                }
            }
        }
        //the case of Bisexual
        if (mainSexualOrientation.equals("bisexual")){
            resUserNames.addAll(this.otherUsers.keySet());
        }
        return resUserNames;
    }
}