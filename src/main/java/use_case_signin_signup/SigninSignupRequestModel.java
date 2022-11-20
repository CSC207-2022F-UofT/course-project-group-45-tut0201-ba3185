package use_case_signin_signup;

import java.util.ArrayList;

public class SigninSignupRequestModel implements SigninSignupInputBoundary{
    private String username;
    private String name;
    private String password;

    public SigninSignupRequestModel(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public ArrayList<Object> getInfo() {
        ArrayList<Object> userInfo = new ArrayList<>();
        userInfo.add(username);
        userInfo.add(name);
        userInfo.add(password);
        return userInfo;
    }
}
