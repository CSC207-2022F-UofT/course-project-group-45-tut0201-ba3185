
import Discovery.DiscoveryUseCase.PreferenceScoreHelper;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import User.UserForTest;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

class PreferenceScoreHelperTest {
    UserForTest mainUser;
    UserForTest user1;
    UserForTest user2;
    UserForTest user3;
    UserForTest user4;
    UserForTest user5;
    UserForTest user6;
    HashMap<UserForTest, Integer> scoreStorage = new HashMap<>();

    @Before
    public void setUp() {
        this.mainUser = new UserForTest("alyssa", "alyssa", "111", "Female", "Female");
        this.user1 = new UserForTest("cami", "cami", "111", "Female", "Male");
        this.user2 = new UserForTest("chris", "chris", "222", "Female", "Male");
        this.user3 = new UserForTest("amber", "amber", "333", "Female", "Male");
        this.user4 = new UserForTest("sunny", "sunny", "333", "Male", "Female");
        this.user5 = new UserForTest("eric", "eric", "333", "Male", "Female");
        this.user6 = new UserForTest("jeniffer", "jeniffer", "333", "Female", "Male");

        /*
        scoreStorage.put(user1, 8);
        scoreStorage.put(user2, 12);
        scoreStorage.put(user3, 8);
        scoreStorage.put(user4, 8);
        scoreStorage.put(user5, 3);
        scoreStorage.put(user6, 1);*/
    }

    @Test//3 users when all with different scores
    public void returnUserList1() {
        scoreStorage.put(user1, 8);
        scoreStorage.put(user5, 3);
        scoreStorage.put(user6, 1);
        ArrayList<String> res = new ArrayList<>();
        res.add(user1.getUsername());
        res.add(user5.getUsername());
        res.add(user6.getUsername());
        PreferenceScoreHelper psh = new PreferenceScoreHelper(scoreStorage);
        Assertions.assertEquals(res, psh.getList());
    }

    @Test//3 users when all with same scores, that should return to the order that
    //userNames added into the Hashmap
    public void returnUserList2() {
        scoreStorage.put(user1, 8);
        scoreStorage.put(user3, 8);
        scoreStorage.put(user4, 8);
        ArrayList<String> res = new ArrayList<>();
        res.add(user1.getUsername());
        res.add(user3.getUsername());
        res.add(user4.getUsername());
        PreferenceScoreHelper psh = new PreferenceScoreHelper(scoreStorage);
        Assertions.assertEquals(res, psh.getList());
    }

    @Test//3 users when 2 have same score and one has higher,
    // should return to the order that userNames added into the Hashmap
    public void returnUserList3() {
        scoreStorage.put(user1, 8);
        scoreStorage.put(user2, 12);
        scoreStorage.put(user4, 8);
        ArrayList<String> res = new ArrayList<>();
        res.add(user2.getUsername());
        res.add(user1.getUsername());
        res.add(user4.getUsername());
        PreferenceScoreHelper psh = new PreferenceScoreHelper(scoreStorage);
        Assertions.assertEquals(res, psh.getList());
    }


}