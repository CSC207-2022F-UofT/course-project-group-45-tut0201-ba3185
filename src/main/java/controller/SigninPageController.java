package controller;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserUseCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * signin page controller class, processes information from the ui and passes them to the use case
 */
public class SigninPageController {
    /**
     * checks if there exists a user with the username
     * @param username: username to check
     * @return true if there exists a user with the username, false otherwise.
     * @throws IOException: if the reader fails to read the file
     */
    public boolean userExist(String username) throws IOException {
        csvManager manager = new csvManager();
        Map<String, UserRequestModel> userMap = manager.readUser();
        UserUseCase usecase = new UserUseCase(userMap);
        return usecase.userExists(username);
    }

    /**
     * checks if the user entered the correct password for the user they are trying to signin with
     * @param username: username of the user
     * @param password: password that the user has entered
     * @return true if the password the user entered is the same as the password of the user.
     * @throws IOException: if the reader fails to the read the file.
     */
    public boolean matchingPassword(String username, String password) throws IOException {
        csvManager manager = new csvManager();
        Map<String, UserRequestModel> userMap = manager.readUser();
        UserUseCase usecase = new UserUseCase(userMap);
        String userPassword = usecase.getUserPassword(username);
        if(userPassword!=null) {
            return usecase.getUserPassword(username).equals(password);
        }
        return false;
    }

    /**
     * sets the currentUser, by writing the user into the currentUser datafile
     * @param username: username of the new current user.
     * @throws IOException: if the reader fails to read the file.
     */
    public void setCurrentUser(String username) throws IOException {
        csvManager manager = new csvManager();
        Map<String, UserRequestModel> userMap = manager.readUser();
        UserRequestModel requestModel = userMap.get(username);
        manager.writeCurrentUser((String) requestModel.getInfo().get(0), (String) requestModel.getInfo().get(1),
                (String) requestModel.getInfo().get(2), (ArrayList<Double>) requestModel.getInfo().get(3),
                (HashMap<String, Object>) requestModel.getInfo().get(4));
    }
}