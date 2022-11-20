package use_case_signin_signup;

import entity.User;

import java.util.Map;

public class SigninSignupUseCase {
    private Map<String, User> userMap;

    public SigninSignupUseCase(Map<String, User> userMap) {
        this.userMap = userMap;
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

    public Map<String, User> getUserMap() {
        return userMap;
    }
}
