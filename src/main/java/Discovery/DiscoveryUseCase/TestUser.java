package Discovery.DiscoveryUseCase;

import User.UserForTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The TestUser class is intended for test when the whole program hasn't fetched with user
 */
public class TestUser {
    UserForTest mainUser;
    UserForTest user1;
    UserForTest user2;
    UserForTest user3;
    UserForTest user4;
    UserForTest user5;
    UserForTest user6;
    ArrayList<UserForTest> otherUsers= new ArrayList<>();
    public TestUser(){
        this.mainUser = new UserForTest("alyssa", "alyssa", "111", "Female", "Female");
        this.user1 = new UserForTest("cami", "cami", "111", "Female", "Male");
        this.user2 = new UserForTest("chris", "chris", "222", "Female", "Male");
        this.user3 = new UserForTest("amber", "amber", "333", "Female", "Male");
        this.user4 = new UserForTest("sunny", "sunny", "333", "Male", "Female");
        this.user5 = new UserForTest("eric", "eric", "333", "Male", "Female");
        this.user6 = new UserForTest("jeniffer", "jeniffer", "333", "Female", "Male");

        ArrayList<String> mainUserInterestRank = new ArrayList<>(Arrays.asList("income", "pet", "marryStatus", "areaOfInterest", "age", "relationshipType"));
        //same as mainUser
        ArrayList<String> lst1 = new ArrayList<>(Arrays.asList("income", "pet", "marryStatus", "areaOfInterest", "age", "relationshipType"));
        //completely opposite
        ArrayList<String> lst2 = new ArrayList<>(Arrays.asList("relationshipType", "age", "areaOfInterest", "marryStatus", "pet", "income"));
        //with more than 2 same as mainUser
        ArrayList<String> lst3 = new ArrayList<>(Arrays.asList("income", "pet", "areaOfInterest", "age", "marryStatus", "relationshipType"));
        //with 1(less than 2) same as mainUser
        ArrayList<String> lst4 = new ArrayList<>(Arrays.asList("income", "age", "areaOfInterest", "marryStatus", "relationshipType", "pet"));
        //with exactly 2
        ArrayList<String> lst5 = new ArrayList<>(Arrays.asList("income", "age", "areaOfInterest", "marryStatus", "pet", "relationshipType"));
        //with exactly 1
        ArrayList<String> lst6 = new ArrayList<>(Arrays.asList("relationshipType", "age", "marryStatus", "pet", "areaOfInterest", "income"));
        mainUser.setInterestRank(mainUserInterestRank);
        user1.setInterestRank(lst1);
        user2.setInterestRank(lst2);
        user3.setInterestRank(lst3);
        user4.setInterestRank(lst4);
        user5.setInterestRank(lst5);
        user6.setInterestRank(lst6);
        this.otherUsers.add(user1);
        this.otherUsers.add(user2);
        this.otherUsers.add(user3);
        this.otherUsers.add(user4);
        this.otherUsers.add(user5);
        this.otherUsers.add(user6);
    }

    public UserForTest getMainUser() {
        return mainUser;
    }
    public ArrayList<UserForTest> getOtherUsers(){
        return this.otherUsers;
    }
}
