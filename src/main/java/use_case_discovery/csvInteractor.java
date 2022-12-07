package use_case_discovery;

import database.csvInterface;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;
import java.io.IOException;
import java.util.Map;
/**
 * csvInteractor access database through the csvInterface.
 * It is the parent class of GenderInteractor and PreferenceScoreCalculator
 */

public class csvInteractor {
    csvInterface manager = new csvManager();
    Map<String, UserRequestModel> otherUsersInfo;
    public csvInteractor(){
        try{
            this.otherUsersInfo = manager.readUser();
        }
        catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
}
