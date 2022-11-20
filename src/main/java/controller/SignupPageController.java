package controller;
import database.csvManager;
import entity.User;
import use_case_signin_signup.UserUseCase;

import java.io.IOException;
import java.util.Map;

public class SignupPageController {

    public boolean create(String username, String name, String password) throws IOException {
        csvManager csvInteractor = new csvManager();
        Map<String, User> userMap = csvInteractor.readUser("database/user.csv");
        UserUseCase usecase = new UserUseCase(userMap);
        if(usecase.addUser(name,username,password)) {
            //csvInteractor.writeUser();
        }
        return false; // remove later
    }
}
