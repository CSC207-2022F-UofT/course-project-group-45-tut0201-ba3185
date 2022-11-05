package User;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


/*
 * this is an entity class to store the information
 * about user's preference
 */

/**
 * About user's info on six characteristics
 * age: stored in int, measure in year
 * areaOfInterest: stored in String that is one of the following: "Sport", "Art", "Music", "Game", "Movie","Cook","Read"
 * income: stored in int, measured in unit of k, i.e. 20 = 20k = 20000
 * marryStatus: stored in String that is one of the following:"Single", "Married", "Divorced"
 * pet: stored in boolean, true or false
 * relationshipType: stored in String that is one of the following: "friend", "one-night state", "short-term", "long-term"
 */

public class UserPreference {
    private static HashMap<String, Object> interest_list;
    private static ArrayList<String> rankOrder;
    HashMap<String, Object> setting;

    /*
     * @param interest_list stores the info of user's anticipation
     * the default order of info storage is by alphabet
     * e.g.["age": 20, "areaOfInterest": "Art", "income": 20, "marryStatus": "Single", "pet": true, relationshipType: "one-night state" ]
     * @param rankOrder stores the order of the characteristics that user puts more weight on, the list follows descending order
     * e.g. ["income", "pet", "marryStatus", "areaOfInterest", "age", "relationshipType"]
     * @param setting
     */


    public static ArrayList<String> getRankOrder(){
        return rankOrder;
    }

    public static HashMap<String, Object> getInterest_list(){
        return interest_list;
    }
}
