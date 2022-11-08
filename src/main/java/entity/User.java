package entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/*
   This is an entity class to store User information,
 */

public class User implements Comparable<User>{
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
    private String username;
    private String name;
    private String password;
    private UserPreference preference;
    private ArrayList<Float> location;
    private ArrayList<User> blockList;
    private HashMap<String, Object> userInfo;
    private ArrayList<String> interestRank;

    public User(String user, String name, String password) {
        this.username = user;
        this.name = name;
        this.password = password;
        // implement default preference later
        this.location = null;
        this.blockList = new ArrayList<User>();
        this.userInfo = new HashMap<String, Object>();
        this.interestRank = new ArrayList<String>(Arrays.asList("age", "areaOfInterest", "income", "maritalStatus", "pet", "relationshipType"));
    }

    public User(String user, String name, String password, ArrayList<Float> loc) {
        this.username = user;
        this.name = name;
        this.password = password;
        // implement default preference later
        this.location = loc;
        this.blockList = new ArrayList<User>();
        this.userInfo = new HashMap<String, Object>();
        this.interestRank = new ArrayList<String>(Arrays.asList("age", "areaOfInterest", "income", "maritalStatus", "pet", "relationshipType"));
    }

    // Getter functions
    public String getUsername() {
        return this.username;
    }

    public ArrayList<Float> getLocation() {
        return this.location;
    }

    public Object getUserInfo(String info) {
        if(this.userInfo.get(info) != null) {
            return this.userInfo.get(info);
        }
        else return "INVALID_KEY";
    }

    public ArrayList<User> getBlockList() {
        return this.blockList;
    }

    public UserPreference getPreference() {
        return this.preference;
    }

    public ArrayList<String> getInterestRank() {
        return this.interestRank;
    }

    // Setter functions

    public boolean setPassword(String pass) {
        if (!this.password.equals(pass)) {
            this.password = pass;
            return true;
        } else return false;
    }

    public void setLocation(ArrayList<Float> loc) {
        this.location = loc;
    }

    public void addBlockList(User user) {
        this.blockList.add(user);
    }

    public void setUserInfo(String key, Object obj) {
        this.userInfo.put(key, obj);
    }

    public void setPreference(String key, Object obj) {
        this.preference.setPreference(key, obj);
    }

    public void setInterestRank(ArrayList<String> lst) {
        this.interestRank = lst;
    }

    @Override
    public int compareTo(User o) {
        if (this.username.equals(o.getUsername())) {
            return 0;
        } else return -1;
    }
}
