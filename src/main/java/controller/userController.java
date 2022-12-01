package controller;

import entity.User;
import use_case_signin_signup.UserUseCase;

public class userController {

    private User currentUser;

    public boolean isUserLoggedin() {
        UserUseCase useCase = new UserUseCase();
        return useCase.isUserLoggedIn();
    }
}