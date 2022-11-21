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
     * preference: A UserPreference of the preferences of the user, (deleted)
     * location: An ArrayList of floats representing the longitude and latitude of the user,
     * blockList: an ArrayList of users of the blocked users,
     * userInfo: A Hashmap pairing String to Objects to contain the information of the user,
     */
    private final String username;
    private final String name;
    private String password;
    private ArrayList<Float> location;
    private ArrayList<String> blockList;
    private HashMap<String, Object> userInfo;
    private ArrayList<String> interestRank;

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
    }

    // case when user decide to give you location data
    public User(String user, String name, String password, ArrayList<Float> loc) {
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


    public ArrayList<String> getBlockList() {
        return this.blockList;
    }

    // Setter functions

    public void addBlockList(String username) {
        this.blockList.add(username);
    }

    public void removeBlockList(String username) {
        this.blockList.remove(username);
    }

    public boolean checkBlockList(String username){
        return this.getBlockList().contains(username);
    }

    @Override
    public int compareTo(User o) {
        if (this.username.equals(o.getUsername())) {
            return 0;
        } else return -1;
    }
}