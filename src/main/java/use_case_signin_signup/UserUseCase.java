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
        if(!userExists(currentUser.getUsername())) {
            userMap.put(currentUser.getUsername(), currentUser);
            return true;
        }
        return false;
    }

    public boolean userExists(String username) {
        return userMap.containsKey(username);
    }

    public String getUserPassword(String username) {
        if(userMap.get(username) != null) {
            return userMap.get(username).getPassword();
        }
        return null;
    }

    public HashMap<String, UserResponseModel> getUserMap() {
        HashMap<String, UserResponseModel> responseMap = new HashMap<>();
        for(User user : userMap.values()) {
            UserResponseModel currentUser = new UserResponseModel();
            currentUser.setInfo(user.getUsername(),user.getName(), user.getPassword());
            responseMap.put(user.getUsername(),currentUser);
        }
        return responseMap;
    }
}
