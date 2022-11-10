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
    private String name;
    private String pass;

    public SigninPageController(SigninPageInputBoundary manager, JTextField username, JTextField name, JPasswordField password) {
        this.manager = manager;
        username.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                updateUsername(username.getText());
            }
        });
        name.addActionListener(ae -> {
            updateName(name.getText());
        });

        password.addActionListener(ae -> {
            updatePassword(String.valueOf(password.getPassword()));
        });
    }

    public void updateTextField() {
        SigninPageRequestModel reqmodel = new SigninPageRequestModel();
        reqmodel.setUsername(this.username);
        reqmodel.setName(this.name);
        reqmodel.setPassword(this.pass);
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePassword(String pass) {
        this.pass = pass;
    }
}
