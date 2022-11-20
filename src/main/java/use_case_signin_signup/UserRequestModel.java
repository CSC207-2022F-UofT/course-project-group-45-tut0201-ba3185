package use_case_signin_signup;

import java.util.ArrayList;

public class UserRequestModel implements UserInputBoundary {
    private String username;
    private String name;
    private String password;
    private ArrayList<Object> userInfo;

    public UserRequestModel() {
        this.userInfo = new ArrayList<>();
    }

    public void setInfo(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public ArrayList<Object> getInfo() {
        this.userInfo.add(username);
        this.userInfo.add(name);
        this.userInfo.add(password);
        return this.userInfo;
    }
}
