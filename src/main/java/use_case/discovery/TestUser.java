package use_case.discovery;

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
    UserForTest user7;
    UserForTest user8;
    UserForTest user9;
    UserForTest user10;
    UserForTest user11;
    UserForTest user12;
    UserForTest user13;
    UserForTest user14;
    UserForTest user15;
    UserForTest user16;
    UserForTest user17;
    UserForTest user18;
    ArrayList<UserForTest> otherUsers;
    public TestUser(){
        this.mainUser = new UserForTest("alyssa", "alyssa", "111", "Female", "Female");
        this.user1 = new UserForTest("cami", "cami", "111", "Female", "Male");
        this.user2 = new UserForTest("chris", "chris", "222", "Female", "Male");
        this.user3 = new UserForTest("amber", "amber", "333", "Female", "Male");
        this.user4 = new UserForTest("sunny", "sunny", "333", "Male", "Female");
        this.user5 = new UserForTest("eric", "eric", "333", "Male", "Female");
        this.user6 = new UserForTest("jeniffer", "jeniffer", "333", "Female", "Male");
        this.user7 = new UserForTest("aa", "aa", "111", "Female", "Male");
        this.user8 = new UserForTest("bb", "bb", "222", "Female", "Male");
        this.user9 = new UserForTest("cc", "cc", "333", "Female", "Male");
        this.user10 = new UserForTest("dd", "dd", "333", "Female", "Female");
        this.user11 = new UserForTest("ee", "ee", "333", "Female", "Female");
        this.user12 = new UserForTest("ff", "ff", "333", "Female", "Male");
        this.user13 = new UserForTest("gg", "gg", "111", "Female", "Male");
        this.user14 = new UserForTest("hh", "hh", "222", "Female", "Male");
        this.user15 = new UserForTest("ii", "ii", "333", "Female", "Male");
        this.user16 = new UserForTest("jj", "jj", "333", "Female", "Female");
        this.user17 = new UserForTest("kk", "kk", "333", "Male", "Female");
        this.user18 = new UserForTest("ll", "ll", "333", "Female", "Male");

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

        //Set interest rank
        mainUser.setInterestRank(mainUserInterestRank);
        user1.setInterestRank(lst1);
        user2.setInterestRank(lst2);
        user3.setInterestRank(lst3);
        user4.setInterestRank(lst4);
        user5.setInterestRank(lst5);
        user6.setInterestRank(lst6);
        user7.setInterestRank(lst1);
        user8.setInterestRank(lst2);
        user9.setInterestRank(lst3);
        user10.setInterestRank(lst4);
        user11.setInterestRank(lst5);
        user12.setInterestRank(lst6);
        user13.setInterestRank(lst1);
        user14.setInterestRank(lst2);
        user15.setInterestRank(lst3);
        user16.setInterestRank(lst4);
        user17.setInterestRank(lst5);
        user18.setInterestRank(lst6);

        this.otherUsers = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8,
                user9, user10, user11, user12, user13, user14, user15,user16,user17,user18));
    }

    public UserForTest getMainUser() {
        return mainUser;
    }
    public ArrayList<UserForTest> getOtherUsers(){
        return this.otherUsers;
    }
}
