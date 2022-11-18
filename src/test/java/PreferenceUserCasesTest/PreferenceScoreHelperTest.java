package PreferenceUserCasesTest;

import Discovery.DiscoveryUseCase.PreferenceScoreHelper;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import User.User;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

class PreferenceScoreHelperTest {
    User user1;
    User user2;
    User user3;
    User user4;
    User user5;
    User user6;
    HashMap<User, Integer> scoreStorage = new HashMap<>();

    @Before
    public void setUp() {
        user1 = new User("cami", "cami", "111");
        user2 = new User("chris", "chris", "222");
        user3 = new User("amber", "amber", "333");
        user4 = new User("sunny", "sunny", "333");
        user5 = new User("eric", "eric", "333");
        user6 = new User("jeniffer", "jeniffer", "333");
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