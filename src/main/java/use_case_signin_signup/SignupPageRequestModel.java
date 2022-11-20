package use_case_signin_signup;

import java.util.ArrayList;

public class SignupPageRequestModel {
    private int id;
    private String username;
    private String name;
    private String password;
    private ArrayList<Double> location;

    public SignupPageRequestModel(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

   public ArrayList<Object> getInfo() {
        ArrayList<Object> userInfo = new ArrayList<Object>();
        userInfo.add(this.username);
        userInfo.add(name);
        userInfo.add(this.password);
        return userInfo;
   }

}
