package use_case_signin_signup;

import database.csvManager;
import entity.User;
import entity.UserFactory;

import java.util.ArrayList;
import java.util.HashMap;

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

    public UserUseCase() {}

    public boolean addUser(String name, String username, String password, ArrayList<Double> location,
                           HashMap<String, Object> userSetting) {
        User currentUser = new User(name,username,password, location, userSetting);
        System.out.println(username);
        if(!userExists(username)) {
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
            currentUser.setInfo(user.getUsername(),user.getName(), user.getPassword(), (Integer) user.getUserInfo("age"),
                    (Integer) user.getUserInfo("income"),
                    (String) user.getUserInfo("gender"), (String) user.getUserInfo("relationshipType"),
                    (String) user.getUserInfo("maritalStatus"), (String) user.getUserInfo("pet"),
                    user.getLocation());
            responseMap.put(user.getUsername(),currentUser);
        }
        return responseMap;
    }

    public boolean isUserLoggedIn() {
        csvManager manager = new csvManager();
        User current = manager.readCurrentUser();
        return current!=null;
    }
}
