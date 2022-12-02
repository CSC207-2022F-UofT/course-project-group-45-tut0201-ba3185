package controller;

import entity.User;
import use_case_signin_signup.UserUseCase;

public class userController {
    public boolean isUserLoggedin() {
        UserUseCase useCase = new UserUseCase();
        return useCase.isUserLoggedIn();
    }

    public void logoutUser() {
        UserUseCase useCase = new UserUseCase();
        useCase.logoutUser();
    }
}
