package controller;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserUseCase;

import java.io.IOException;
import java.util.HashMap;

public class SigninPageController {
    public boolean userExist(String username) throws IOException {
        csvManager manager = new csvManager();
        HashMap<String, UserRequestModel> userMap = manager.readUser("src/main/java/database/user.csv");
        UserUseCase usecase = new UserUseCase(userMap);
        return usecase.userExists(username);
    }

    public boolean matchingPassword(String username, String password) throws IOException {
        csvManager manager = new csvManager();
        HashMap<String, UserRequestModel> userMap = manager.readUser("src/main/java/database/user.csv");
        UserUseCase usecase = new UserUseCase(userMap);
        String userPassword = usecase.getUserPassword(username);
        if(userPassword!=null) {
            return usecase.getUserPassword(username).equals(password);
        }
        return false;
    }
}