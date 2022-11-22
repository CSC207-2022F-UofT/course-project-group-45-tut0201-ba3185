package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
    The UserPreference class is an entity that contains the preferences and preference rank of the User
 */
public class UserPreference {
    /*
     * @param:
     * preferences: A Hashmap mapping preference to corresponding object value
     * interestRank: an ArrayList of strings ranking the importance of preferences of the user.
     */
    private HashMap<String, Object> preferences;
    private ArrayList<String> interestRank;

    public UserPreference(ArrayList<Object> pref) {
        String[] key = {"age", "areaOfInterest", "income", "maritalStatus", "pet", "relationshipType"};

        for( int i = 0 ; i < key.length ; i++ ) {
            this.preferences.put(key[i], pref.get(i));
        }

        this.interestRank = new ArrayList<String>(Arrays.asList("age", "areaOfInterest", "income", "maritalStatus", "pet", "relationshipType"));
    }

    // setter functions
    public void setPreference(String key, Object obj) {
        this.preferences.put(key, obj);
    }

    public void setInterestRank(ArrayList<String> lst) {
        this.interestRank = lst;
    }
    public void setRank(String key, int rank) {
        this.interestRank.remove(key);
        this.interestRank.add(rank-1, key); // if rank is from 1:n , will need to change if rank is from 0:n
    }

    // getter functions
    public Object getPreference(String key) {
        return this.preferences.get(key);
    }

    public ArrayList<String> getInterestRank() {
        return this.interestRank;
    }
}
