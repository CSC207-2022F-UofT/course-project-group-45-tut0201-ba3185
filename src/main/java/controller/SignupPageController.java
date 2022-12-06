package controller;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserUseCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        String username = requestModel.getUsername();
        String name = requestModel.getName();
        String password = requestModel.getPassword();
        String interestRank = requestModel.getInterestRank();
        List<Double> location = requestModel.getLocation();
        Map<String, Object> userSetting = requestModel.getUserSetting();
        // Check if the user is already in the Database
        if(usecase.addUser(username, name, password, location, userSetting, interestRank)) {
            csvManager.writeUser(usecase.getUserMap());
            csvManager.writeCurrentUser(username, name, password, location, userSetting, interestRank);
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
