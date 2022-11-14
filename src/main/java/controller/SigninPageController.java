package controller;
import entity.User;
import use_case_signin_signup.SigninPageRequestModel;
import use_case_signin_signup.SigninPageInputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SigninPageController {
    private SigninPageInputBoundary manager;
    private String username;
    private String pass;

    public SigninPageController(SigninPageInputBoundary manager, JTextField username, JPasswordField password) {
        this.manager = manager;
        username.addActionListener(ae -> {
            this.username = username.getText();
        });

        password.addActionListener(ae -> {
            this.pass = String.valueOf(password.getPassword());
        });
    }

    public void updateTextField() {
        SigninPageRequestModel reqmodel = new SigninPageRequestModel();
        reqmodel.setUsername(this.username);
        reqmodel.setPassword(this.pass);
    }
}