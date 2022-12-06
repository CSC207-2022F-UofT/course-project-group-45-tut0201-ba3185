package usecase;

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

        //Set users' location
        ArrayList<Double> mainLocation = new ArrayList<>();
        mainLocation.add(-79.39688861560464);
        mainLocation.add(43.65985123321202);
        mainUser.setLocation(mainLocation);

        ArrayList<Double> location1 = new ArrayList<>();
        location1.add(-79.07566369402424);
        location1.add(43.09140474351913);
        user1.setLocation(location1);

        ArrayList<Double> location2 = new ArrayList<>();
        location2.add(-79.39653244306562);
        location2.add(43.66082236600782);
        user2.setLocation(location2);

        ArrayList<Double> location3 = new ArrayList<>();
        location3.add(-79.07566369402424);
        location3.add(43.09140474351913);
        user3.setLocation(location3);

        ArrayList<Double> location4 = new ArrayList<>();
        location4.add(-79.39896958562463);
        location4.add(43.658001119030466);
        user4.setLocation(location4);

        ArrayList<Double> location5 = new ArrayList<>();
        location5.add(-79.3840691279347);
        location5.add(43.664735037309995);
        user5.setLocation(location5);

        ArrayList<Double> location6 = new ArrayList<>();
        location6.add(-79.38039449903667);
        location6.add(43.662471728902105);
        user6.setLocation(location6);

        ArrayList<Double> location7 = new ArrayList<>();
        location7.add(-79.07566369402424);
        location7.add(43.09140474351913);
        user7.setLocation(location7);

        ArrayList<Double> location8 = new ArrayList<>();
        location8.add(-79.07566369402424);
        location8.add(43.09140474351913);
        user8.setLocation(location8);

        ArrayList<Double> location9 = new ArrayList<>();
        location9.add(-79.07566369402424);
        location9.add(43.09140474351913);
        user9.setLocation(location9);

        ArrayList<Double> location10 = new ArrayList<>();
        location10.add(-79.07566369402424);
        location10.add(43.09140474351913);
        user10.setLocation(location10);

        ArrayList<Double> location11 = new ArrayList<>();
        location11.add(-79.07566369402424);
        location11.add(43.09140474351913);
        user11.setLocation(location11);

        ArrayList<Double> location12 = new ArrayList<>();
        location12.add(-79.07566369402424);
        location12.add(43.09140474351913);
        user12.setLocation(location12);

        ArrayList<Double> location13 = new ArrayList<>();
        location13.add(-79.07566369402424);
        location13.add(43.09140474351913);
        user13.setLocation(location13);

        ArrayList<Double> location14 = new ArrayList<>();
        location14.add(-79.07566369402424);
        location14.add(43.09140474351913);
        user14.setLocation(location14);

        ArrayList<Double> location15 = new ArrayList<>();
        location15.add(-79.07566369402424);
        location15.add(43.09140474351913);
        user15.setLocation(location15);

        ArrayList<Double> location16 = new ArrayList<>();
        location16.add(-79.07566369402424);
        location16.add(43.09140474351913);
        user16.setLocation(location16);

        ArrayList<Double> location17 = new ArrayList<>();
        location17.add(-79.07566369402424);
        location17.add(43.09140474351913);
        user17.setLocation(location17);

        ArrayList<Double> location18 = new ArrayList<>();
        location18.add(-79.07566369402424);
        location18.add(43.09140474351913);
        user18.setLocation(location18);
    }

    public UserForTest getMainUser() {
        return mainUser;
    }
    public ArrayList<UserForTest> getOtherUsers(){
        return this.otherUsers;
    }
}