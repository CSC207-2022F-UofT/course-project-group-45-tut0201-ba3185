package entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/*
   This is an entity class to store User information,
 */

public class User implements Comparable<User> {
    /*
     * @param
     * username: A String of the username of the user,
     * name: A String of the name of the user,
     * password: A String of the password of the user,
     * preference: A UserPreference of the preferences of the user,
     * location: An ArrayList of floats representing the longitude and latitude of the user,
     * blockList: an ArrayList of users of the blocked users,
     * userInfo: A Hashmap pairing String to Objects to contain the information of the user,
     */
    private final String username;
    private final String name;
    private String password;
    private ArrayList<Double> location;
    private ArrayList<String> blockList;
    private HashMap<String, Object> userInfo;
    private ArrayList<String> interestRank;
    private ArrayList<String> userChatted;

    // case when user does not give location data
    public User(String user, String name, String password) {
        this.username = user;
        this.name = name;
        this.password = password;
        // implement default preference later
        this.location = null;
        this.blockList = new ArrayList<String>();
        this.userInfo = new HashMap<String, Object>();
        this.interestRank = new ArrayList<String>(Arrays.asList("age", "areaOfInterest", "income", "maritalStatus", "pet", "relationshipType"));
<<<<<<< HEAD
        this.userChatted = new ArrayList<String>();
=======
>>>>>>> main
    }

    // case when user decide to give you location data
    public User(String user, String name, String password, ArrayList<Double> loc) {
        this.username = user;
        this.name = name;
        this.password = password;
        // implement default preference later
        this.location = loc;
        this.blockList = new ArrayList<String>();
        this.userInfo = new HashMap<String, Object>();
        this.interestRank = new ArrayList<String>(Arrays.asList("age", "areaOfInterest", "income", "maritalStatus", "pet", "relationshipType"));
    }

    // Getter functions
    public String getUsername() {
        return this.username;
    }

    public ArrayList<Double> getLocation() {
        return this.location;
    }

    public Object getUserInfo(String info) {
        if(this.userInfo.get(info) != null) {
            return this.userInfo.get(info);
        }
        else return "INVALID_KEY";
    }

    public ArrayList<String> getBlockList() {
        return this.blockList;
    }

    public ArrayList<String> getInterestRank() {
        return this.interestRank;
    }

    public String getPassword() {
        return this.password;
    }

<<<<<<< HEAD
    public ArrayList<String> getUserChatted() {
        return userChatted;
    }

=======
>>>>>>> main
    // Setter functions

    public boolean setPassword(String pass) {
        if (!this.password.equals(pass)) {
            this.password = pass;
            return true;
        } else return false;
    }

    public void setLocation(ArrayList<Double> loc) {
        this.location = loc;
    }

    public void addBlockList(String username) {
        this.blockList.add(username);
    }

    public void setUserInfo(String key, Object obj) {
        this.userInfo.put(key, obj);
    }
<<<<<<< HEAD

=======
>>>>>>> main
    public void setInterestRank(ArrayList<String> lst) {
        this.interestRank = lst;
    }

<<<<<<< HEAD
    public void addUserChatted(String target){
        this.userChatted.add(target);
    }

=======
>>>>>>> main
    @Override
    public int compareTo(User o) {
        return Integer.compare(o.hashCode(), this.hashCode());
    }

    @Override
    public String toString() {
        return this.username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash = 17 * hash + (username != null ? username.hashCode() : 0);
        hash = 17 * hash + (password != null ? password.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) { return true; }
        if(o == null) { return false; }
        if(o.getClass() != this.getClass()) { return false; }
        return ((User) o).getUsername().equals(this.username);
    }
}