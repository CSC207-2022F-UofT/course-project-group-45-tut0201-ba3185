package use_case_signin_signup;

import entity.User;
import entity.UserFactory;

import java.util.HashMap;
import java.util.Map;

public class UserUseCase {
    private HashMap<String, User> userMap;

    public UserUseCase(HashMap<String, UserRequestModel> userMap) {
        this.userMap = new HashMap<>();
        UserFactory factory = new UserFactory();
        for(UserRequestModel requestModel : userMap.values()) {
            User current = factory.create(requestModel);
            this.userMap.put(current.getUsername(),current);
        }
    }

    public boolean addUser(String name, String username, String password) {
        User currentUser = new User(name,username,password);
        if(!userExists(currentUser)) {
            userMap.put(currentUser.getUsername(), currentUser);
            return true;
        }
        return false;
    }

    public boolean userExists(User user) {
        for(User usr : userMap.values()) {
            if(user.getUsername().equals(usr.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public HashMap<String, User> getUserMap() {
        return userMap;
    }
}
