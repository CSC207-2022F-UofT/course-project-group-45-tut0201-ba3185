package controller;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserUseCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The Signup page controller class, processes information from UI and passes them to the use case
 */
public class SignupPageController {

    /**
     * creates a new user with current information
     * @param requestModel: UserRequestModel with user information
     * @return true if the user is created, and false if the user is not created
     * @throws IOException: if reader failed to read file
     */
    public boolean create(UserRequestModel requestModel) throws IOException {
        csvManager csvManager = new csvManager();
        Map<String, UserRequestModel> userMap = csvManager.readUser();
        UserUseCase usecase = new UserUseCase(userMap);
        String username = (String) requestModel.getInfo().get(0);
        String name = (String) requestModel.getInfo().get(1);
        String password = (String) requestModel.getInfo().get(2);
        ArrayList<Double> location = (ArrayList<Double>) requestModel.getInfo().get(3);
        HashMap<String, Object> userSetting = (HashMap<String, Object>) requestModel.getInfo().get(4);
        // Check if the user is already in the Database
        if(usecase.addUser(username, name, password, location, userSetting)) {
            csvManager.writeUser(usecase.getUserMap());
            csvManager.writeCurrentUser(username, name, password, location, userSetting);
            return true;
        }
        return false;
    }

    /**
     * checks if there exists a user with the username already
     * @param username: username to check
     * @return: true if there exists a user with that username, false if there is not a user.
     * @throws IOException
     */
    public boolean userExist(String username) throws IOException {
        csvManager csvManager = new csvManager();
        Map<String, UserRequestModel> userMap = csvManager.readUser();
        UserUseCase usecase = new UserUseCase(userMap);

        return usecase.userExists(username);
    }
}