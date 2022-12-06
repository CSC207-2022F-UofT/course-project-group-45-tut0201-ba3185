package controller;

import entity.User;
import use_case_signin_signup.UserUseCase;

/**
 * userController is the controller class that checks the state of current user
 */
public class userController {
    /**
     * checks if there are any user currently logged in
     * @return true if there is a user logged in, false if there isn't
     */
    public boolean isUserLoggedin() {
        UserUseCase useCase = new UserUseCase();
        return useCase.isUserLoggedIn();
    }
    public void logoutUser() {
        UserUseCase useCase = new UserUseCase();
        useCase.logoutUser();
    }
}