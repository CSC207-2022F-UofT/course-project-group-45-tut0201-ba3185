package controller;
import database.csvInteractor;
import entity.User;
import entity.Users;
import use_case_signin_signup.SigninSignupUseCase;
import use_case_signin_signup.SignupPageRequestModel;
import use_case_signin_signup.SignupPageInputBoundary;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class SignupPageController {

    public boolean create(String username, String name, String password) throws IOException {
        csvInteractor csvInteractor = new csvInteractor();
        Map<String, User> userMap = csvInteractor.readUser("database/user.csv");
        SigninSignupUseCase usecase = new SigninSignupUseCase(userMap);
        if(usecase.addUser(name,username,password)) {
            //csvInteractor.writeUser();
        }
        return false; // remove later
    }
}
