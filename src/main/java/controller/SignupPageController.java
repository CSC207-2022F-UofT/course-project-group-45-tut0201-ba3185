package controller;
import database.csvManager;
import use_case.signin_signup.UserRequestModel;
import use_case.signin_signup.UserUseCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SignupPageController {

    public boolean create(UserRequestModel requestModel) throws IOException {
        csvManager csvManager = new csvManager();
        HashMap<String, UserRequestModel> userMap = csvManager.readUser("src/main/java/database/user.csv");
        UserUseCase usecase = new UserUseCase(userMap);
        String username = (String) requestModel.getInfo().get(0);
        String name = (String) requestModel.getInfo().get(1);
        String password = (String) requestModel.getInfo().get(2);
        ArrayList<Double> location = (ArrayList<Double>) requestModel.getInfo().get(3);
        HashMap<String, Object> userSetting = (HashMap<String, Object>) requestModel.getInfo().get(4);
        // Check if the user is already in the Database
        if(usecase.addUser(username, name, password, location, userSetting)) {
            csvManager.writeUser(usecase.getUserMap(), "src/main/java/database/user.csv");
            csvManager.writeCurrentUser(username, name, password, location, userSetting,
                    "src/main/java/database/currentUser.csv");
            return true;
        }
        return false;
    }

    public boolean userExist(String username) throws IOException {
        csvManager csvManager = new csvManager();
        HashMap<String, UserRequestModel> userMap = csvManager.readUser("src/main/java/database/user.csv");
        UserUseCase usecase = new UserUseCase(userMap);

        return usecase.userExists(username);
    }
}
