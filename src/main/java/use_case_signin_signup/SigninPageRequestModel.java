package use_case_signin_signup;
import entity.User;

import javax.swing.*;

public class SigninPageRequestModel {
    private String username;
    private String name;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }
}
