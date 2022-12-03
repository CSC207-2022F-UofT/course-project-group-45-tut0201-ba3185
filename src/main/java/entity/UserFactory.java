package entity;
import use_case_signin_signup.UserRequestModel;

import java.util.ArrayList;
import java.util.HashMap;

public class UserFactory {

    /**
     * The UserFactory enttiy is to create new users from information from the requestModel
     */

    /**
     * The create method for UserFactory, creates a new user with information from the requestModel
     * @param requestModel: UserRequestmodel containing all the information needed to make a new user
     * @return A new User object created from the information in the requestModel
     */
    public User create(UserRequestModel requestModel) {
        ArrayList<Object> userInfo = requestModel.getInfo();
        return new User((String) userInfo.get(0), (String) userInfo.get(1), (String) userInfo.get(2),
                (ArrayList<Double>) userInfo.get(3), (HashMap<String, Object>) userInfo.get(4));
    }
}
