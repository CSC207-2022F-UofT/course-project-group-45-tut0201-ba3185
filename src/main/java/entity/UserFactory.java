package entity;
import use_case.signin_signup.UserRequestModel;

import java.util.ArrayList;
import java.util.HashMap;

public class UserFactory {
    public User create(UserRequestModel requestModel) {
        ArrayList<Object> userInfo = requestModel.getInfo();
        return new User((String) userInfo.get(0), (String) userInfo.get(1), (String) userInfo.get(2),
                (ArrayList<Double>) userInfo.get(3), (HashMap<String, Object>) userInfo.get(4));
    }
}
