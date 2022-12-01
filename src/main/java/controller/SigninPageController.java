package controller;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserResponseModel;
import use_case_signin_signup.UserUseCase;

import java.io.IOException;
import java.util.ArrayList;
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

    public void setCurrentUser(String username) throws IOException {
        csvManager manager = new csvManager();
        HashMap<String, UserRequestModel> userMap = manager.readUser("src/main/java/database/user.csv");
        UserRequestModel requestModel = userMap.get(username);
        manager.writeCurrentUser((String) requestModel.getInfo().get(0), (String) requestModel.getInfo().get(1),
                (String) requestModel.getInfo().get(2), (ArrayList<Double>) requestModel.getInfo().get(3),
                (HashMap<String, Object>) requestModel.getInfo().get(4),
                "src/main/java/database/currentUser.csv");
    }
}
