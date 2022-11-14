package use_case_signin_signup;

import java.util.ArrayList;

public class SignupPageRequestModel {
    private String username;
    private String name;
    private String password;
    private ArrayList<Double> location;

    // setter functions
    public void setUsername(String username) {
        this.username = username;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setLocation(ArrayList<Double> loc) {
        this.location = loc;
    }

    // getter functions
    public String getUsername() {
        return this.username;
    }
    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }
    public ArrayList<Double> getLocation() {
        return this.location;
    }

}
