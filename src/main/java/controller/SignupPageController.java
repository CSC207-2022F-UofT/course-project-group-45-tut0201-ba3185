package controller;
import use_case_signin_signup.SignupPageRequestModel;
import use_case_signin_signup.SignupPageInputBoundary;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SignupPageController {
    private SignupPageInputBoundary manager;
    private String username;
    private String name;
    private String password;
    private ArrayList<Float> location;

    public SignupPageController(SignupPageInputBoundary manager, JTextField username, JTextField name,
                                JPasswordField password, JButton SignupButton, JButton switchView) {
        this.manager = manager;
        username.addActionListener(ae -> {
            this.username = username.getText();
        });
        name.addActionListener(ae -> {
            this.name = name.getText();
        });
        password.addActionListener(ae -> {
            this.password = String.valueOf(password.getPassword());
        });
        SignupButton.addMouseListener( new MouseAdapter() {
            public void mouseClicked() {
                // send over the right function
            }
        });
        switchView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // send over the function to switch view
            }
        });
    }


}
