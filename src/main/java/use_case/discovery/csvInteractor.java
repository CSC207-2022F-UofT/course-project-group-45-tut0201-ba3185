package use_case.discovery;

import database.csvInterface;
import database.csvManager;
import use_case.signin_signup.UserRequestModel;
import java.io.IOException;
import java.util.Map;
/**
 * csvInteractor access database through the csvInterface.
 * It is the parent class of GenderInteractor, PreferenceScoreCalculator and
 * SearchScoreCalculator
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