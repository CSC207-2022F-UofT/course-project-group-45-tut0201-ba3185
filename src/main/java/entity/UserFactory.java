package entity;

import use_case_signin_signup.SignupPageRequestModel;

import java.util.ArrayList;

public class UserFactory {
    public User create(SignupPageRequestModel requestModel) {
        ArrayList<Object> userInfo = requestModel.getInfo();
        return new User((String) userInfo.get(0), (String) userInfo.get(1), (String) userInfo.get(2));
    }
}
