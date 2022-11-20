package controller;
import database.csvManager;
import entity.User;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserUseCase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignupPageController {

    public boolean create(String username, String name, String password) throws IOException {
        csvManager csvManager = new csvManager();
        HashMap<String, UserRequestModel> userMap = csvManager.readUser("database/user.csv");
        UserUseCase usecase = new UserUseCase(userMap);
        // Check if the user is already in the Database
        if(usecase.addUser(name,username,password)) {
            //csvInteractor.writeUser();
        }
        return false; // remove later
    }
}
