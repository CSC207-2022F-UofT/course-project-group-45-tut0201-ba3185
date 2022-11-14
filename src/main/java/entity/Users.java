package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Users {
    private static HashMap<String, User> userList;

    public Users() {
        userList = new HashMap<>();
    }
    public void addUser(String username, User user) {
        userList.put(username, user);
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

