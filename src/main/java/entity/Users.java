package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Users {
    private static HashMap<String, User> userList;
    private static User currentUser;

    public Users() {
        userList = new HashMap<>();
    }
    public void addUser(String username, User user) {
        userList.put(username, user);
    }

    public static entity.User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }


    public ArrayList<User> getUserList() {
        return (ArrayList<User>) userList.values();
    }

    public Set<String> getUsernameList() {
        return userList.keySet();
    }

    public User getUser(String username) {
        if(userList.containsKey(username)) {
            return userList.get(username);
        }
        return null;
    }
}

