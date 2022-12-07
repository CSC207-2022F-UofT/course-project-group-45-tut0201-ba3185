package use_case_discovery;


import database.csvInterface;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.Map;

public class ParentClass {
    csvInterface manager = new csvManager();
    Map<String, UserRequestModel> otherUsersInfo;
    public ParentClass(){
        try{
            this.otherUsersInfo = manager.readUser();
        }
        catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
}
