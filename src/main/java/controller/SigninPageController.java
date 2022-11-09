package controller;
import entity.User;
import use_case_signin_signup.SigninPageRequestModel;
import use_case_signin_signup.SigninPageInputBoundary;

import javax.swing.*;

public class SigninPageController {
    private SigninPageInputBoundary manager;

    public SigninPageController(SigninPageInputBoundary manager) {
        this.manager = manager;
    }

    public void updateTextField(JTextField username, JTextField name, JPasswordField password) {
        
    }
}
