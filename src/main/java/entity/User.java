package entity;
import java.util.*;

/*
   This is an entity class to store User information,
 */

public class User implements Comparable<User> {
    /*
     * The User class that holds the profile and information of the user.
     * implements comparable to be able to check if two users are the same user based on their username
     *
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
    private List<Double> location;
    private List<String> blockList;
    private Map<String, Object> userInfo;
    private List<String> interestRank;
    private List<String> userChatted;

    /*
     * Constructor for the User object
     *
     * @param username: username of the user
     * @param name: name of user
     * @param password: password of the user
     * @param location: location of the user in longitude and latitude
     * @param userInfo: all user information that was reported when creating the user
     */
    public User(String username, String name, String password, List<Double> location,
                Map<String, Object> userInfo) {

        this.username = username;
        this.name = name;
        this.password = password;
        this.location = location;
        this.userInfo = userInfo;
        this.blockList = new ArrayList<String>();
    }

    // Getter functions

    /*
    *  Getter for the username of user
    *  @return the username of the user
    */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter for the name of the user
     *
     * @return name of the user
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the location of the user
     * @return returns the location of the user as a list of doubles
     */
    public List<Double> getLocation() {
        return this.location;
    }

    /**
     * getter for the userInfo of the user
     * @param info: String key for which info they need
     * @return the corresponding Object for the key info, if the key is invalid, returns String "INVALID_KEY"
     */

    public Object getUserInfo(String info) {
        if(this.userInfo.get(info) != null) {
            return this.userInfo.get(info);
        }
        else return "INVALID_KEY";
    }

    /**
     * getter for the block list
     * @return a list of blocked users
     */
    public List<String> getBlockList() {
        return this.blockList;
    }

    /**
     * getting the rank of interests of the user
     * @return returns a list of their interest ranked
     */
    public List<String> getInterestRank() {
        return this.interestRank;
    }

    /**
     * getting the password of the user
     * @return the password of the user
     */
    public String getPassword() {
        return this.password;
    }

    // Setter functions

    /**
     * sets a new password for the user
     * @param pass: new password for the user
     * @return true if the new password is not the old password, else returns false
     */
    public boolean setPassword(String pass) {
        if (!this.password.equals(pass)) {
            this.password = pass;
            return true;
        } else return false;
    }

    /**
     * sets a new location of the user
     * @param loc: new location fo the user
     */
    public void setLocation(ArrayList<Double> loc) {
        this.location = loc;
    }

    /**
     * adds a new user to this users blocklist
     * @param username: username of the user being blocked
     */
    public void addBlockList(String username) {
        this.blockList.add(username);
    }

    /**
     * updates or sets a userinfo
     * @param key: key of the userInfo
     * @param obj: object of the userInfo being set
     */
    public void setUserInfo(String key, Object obj) {
        this.userInfo.put(key, obj);
    }

    /**
     * update the ranking of the interests
     * @param lst: new list of the ranking of interests
     */
    public void setInterestRank(ArrayList<String> lst) {
        this.interestRank = lst;
    }

    /**
     * compares the hashcode of the two users to see if they are the same
     * @param o the object to be compared.
     * @return -1 if the two users are not the same, and 0 if they are the same
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(o.hashCode(), this.hashCode());
    }

    /**
     * Give a string representation of the user object
     * @return the username of the user object
     */
    @Override
    public String toString() {
        return this.username;
    }

    /**
     * the hashcode of the user object, allows compareTo to work
     * @return an integer of the hashcode of the user object
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash = 17 * hash + (username != null ? username.hashCode() : 0);
        hash = 17 * hash + (password != null ? password.hashCode() : 0);
        return hash;
    }

    /**
     * compares the username of two users
     * @param o: the other user
     * @return if the username of the two users are the same
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) { return true; }
        if(o == null) { return false; }
        if(o.getClass() != this.getClass()) { return false; }
        return ((User) o).getUsername().equals(this.username);
    }
}