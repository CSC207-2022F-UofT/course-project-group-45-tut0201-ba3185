package use_case_discovery;

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

        this.mainUser = new UserForTest("alyssa", "alyssa", "111", "Female", "Female",
       10, 23, true, "Long-term", "Single", "Sport");

        this.user1 = new UserForTest("cami", "cami", "111", "Female", "Female",
                7, 27, true, "Short-term", "Married", "Art");
        this.user2 = new UserForTest("chris", "chris", "222", "Female", "Female",
                10, 40, true, "One-Night", "Divorce", "Game");
        this.user3 = new UserForTest("amber", "amber", "333", "Female", "Male",
                18, 70, false, "Short-term", "Single", "Sport");
        this.user4 = new UserForTest("sunny", "sunny", "333", "Female", "Female",
                13, 21, false, "Long-term", "Single", "Music");
        this.user5 = new UserForTest("jeniffer", "jeniffer", "333", "Female", "Female",
                6, 19, false, "Long-term", "Single", "Music");
        this.user6 = new UserForTest("oh", "o'h", "333", "Female", "Male",
                3, 21, false, "Long-term", "Single", "Music");
        this.user7 = new UserForTest("aa", "aa", "111", "Female", "Male",
                10, 17, false, "Short-term", "Married", "Cook");
        this.user8 = new UserForTest("bb", "bb", "222", "Female", "Male",
                11, 24, true, "Friend", "Divorce", "Art");
        this.user9 = new UserForTest("cc", "cc", "333", "Female", "Male",
                20, 34, true, "Long-term", "Single", "Movie");
        this.user10 = new UserForTest("dd", "dd", "333", "Female", "Female",
                10, 10, false, "One-Night", "Single", "Cook");
        this.user11 = new UserForTest("ee", "ee", "333", "Female", "Female",
                18, 19, false, "Friend", "Single", "Cook");
        this.user12 = new UserForTest("ff", "ff", "333", "Female", "Male",
                12, 24, true, "Friend", "Divorce", "Cook");
        this.user13 = new UserForTest("gg", "gg", "111", "Female", "Male",
                22, 32, true, "Short-term", "Divorce", "Cook");
        this.user14 = new UserForTest("hh", "hh", "222", "Female", "Male",
                17, 21, false, "One-Night", "Single", "Movie");
        this.user15 = new UserForTest("ii", "ii", "333", "Female", "Male",
                13, 37, true, "Long-term", "De", "Cook");
        this.user16 = new UserForTest("jj", "jj", "333", "Female", "Female",
                21, 27, false, "Long-term", "Single", "Cook");
        this.user17 = new UserForTest("kk", "kk", "333", "Male", "Female",
                15, 25, false, "One-Night", "Single", "Cook");
        this.user18 = new UserForTest("ll", "ll", "333", "Female", "Male",
                10, 36, true, "Long-term", "Divorce", "Cook");


        this.otherUsers = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5,user6, user7, user8,user9, user10,
                user11,user12,user13,user14,user15,user16,user17,user18));
    }

    public UserForTest getMainUser() {
        return mainUser;
    }
    public ArrayList<UserForTest> getOtherUsers(){
        return this.otherUsers;
    }
}
