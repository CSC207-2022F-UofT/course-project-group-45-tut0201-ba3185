package use_case_signin_signup;

import database.csvManager;
import entity.User;
import entity.UserFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class UserUseCase {
    /**
     * use case of the user
     *
     * @param userMap: all the users in the database currently
     */
    private Map<String, User> userMap;

    public UserUseCase(Map<String, UserRequestModel> userMap) {
        /**
         * constructor of UserUseCase, creates and sets up the userMap
         */
        this.userMap = new HashMap<>();
        UserFactory factory = new UserFactory();
        for(UserRequestModel requestModel : userMap.values()) {
            User current = factory.create(requestModel);
            this.userMap.put(current.getUsername(),current);
        }
    }

    /**
     * default constructor of UserUseCase
     */
    public UserUseCase() {}

    /**
     * adds a new user to the userMap
     * @param name: name of the user
     * @param username: username of the user
     * @param password: password of the user
     * @param location: location of the user
     * @param userSetting: userSettings of the user
     * @return true if there are no existing users with the same username already in the userMap, false otherwise.
     */
    public boolean addUser(String name, String username, String password, List<Double> location,
                           Map<String, Object> userSetting) {

        User currentUser = new User(name,username,password, location, userSetting);
        System.out.println(username);
        if(!userExists(username)) {
            userMap.put(currentUser.getUsername(), currentUser);
            return true;
        }
        return false;
    }

    /**
     * checks if a user is already in userMap by checking username
     * @param username: username of the user
     * @return true if there exists a user with the username, false otherwise.
     */
    public boolean userExists(String username) {
        return userMap.containsKey(username);
    }

    /**
     * gets password of the user with the username
     * @param username: username of the user
     * @return password of user with username, null otherwise.
     */
    public String getUserPassword(String username) {
        if(userMap.get(username) != null) {
            return userMap.get(username).getPassword();
        }
        return null;
    }

    /**
     * returns the userMap
     * @return returns the userMap
     */
    public Map<String, UserResponseModel> getUserMap() {
        Map<String, UserResponseModel> responseMap = new HashMap<>();
        for(User user : userMap.values()) {
            UserResponseModel currentUser = new UserResponseModel();
            currentUser.setInfo(user.getUsername(),user.getName(), user.getPassword(), (Integer) user.getUserInfo("age"),
                    (Integer) user.getUserInfo("income"),
                    (String) user.getUserInfo("gender"), (String) user.getUserInfo("relationshipType"),
                    (String) user.getUserInfo("maritalStatus"), (String) user.getUserInfo("pet"),
                    user.getLocation(), (String) user.getUserInfo("sexualOrientation"));
            responseMap.put(user.getUsername(),currentUser);
        }
        return responseMap;
    }

    /**
     * checks if the user is logged in
     * @return true if there is a user logged in, false otherwise.
     */
    public boolean isUserLoggedIn() {
        csvManager manager = new csvManager();
        UserResponseModel current = manager.readCurrentUser();
        return current!=null;
    }

    public void logoutUser() {
        csvManager manager = new csvManager();
        manager.logoutUser();

    }
}
