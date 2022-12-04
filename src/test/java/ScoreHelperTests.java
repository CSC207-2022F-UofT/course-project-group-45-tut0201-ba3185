import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_discovery.ScoreHelper;
import use_case_discovery.UserForTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreHelperTests {
     UserForTest user1;
     UserForTest user2;
     UserForTest user3;
     UserForTest user4;
     UserForTest user5;
     HashMap<UserForTest, Integer> scoreList;


    @BeforeEach
    public void setUp(){
        user1 = new UserForTest("cami", "cami", "111", "Female", "Male",
                7, 27, true, "Short-term", "Married", "Art");
        user2 = new UserForTest("chris", "chris", "222", "Female", "Male",
                10, 40, true, "One-Night", "Divorce", "Game");
        user3 = new UserForTest("amber", "amber", "333", "Female", "Male",
                18, 70, false, "Long-term", "Single", "Sport");
        user4 = new UserForTest("sunny", "sunny", "333", "Male", "Female",
                6, 19, false, "Short-term", "Single", "Music");
        user5 = new UserForTest("jeniffer", "jeniffer", "333", "Female", "Male",
                12, 21, false, "Long-term", "Single", "Music");

        scoreList = new HashMap<>();
    }

    @Test
    public void sortWithDifferentScore(){

        scoreList.put(user1, 2);
        scoreList.put(user2, 3);
        scoreList.put(user3, 1);
        scoreList.put(user4, 6);
        scoreList.put(user5, 0);
        ScoreHelper helper = new ScoreHelper(scoreList);
        ArrayList<String> expected = new ArrayList<>();
        expected.add(user4.getUsername());
        expected.add(user2.getUsername());
        expected.add(user1.getUsername());
        expected.add(user3.getUsername());
        expected.add(user5.getUsername());
        Assertions.assertEquals(expected, helper.getList());

    }

    @Test
    public void sortWithSameScore(){

        scoreList.put(user1, 2);
        scoreList.put(user2, 2);
        scoreList.put(user3, 2);
        ScoreHelper helper = new ScoreHelper(scoreList);
        ArrayList<String> expected = new ArrayList<>();
        expected.add(user1.getUsername());
        expected.add(user2.getUsername());
        expected.add(user3.getUsername());
        Assertions.assertEquals(expected, helper.getList());

    }

    @Test
    public void sortWithOneSameScore(){

        scoreList.put(user1, 2);
        scoreList.put(user2, 3);
        scoreList.put(user3, 1);
        scoreList.put(user4, 6);
        scoreList.put(user5, 2);
        ScoreHelper helper = new ScoreHelper(scoreList);
        ArrayList<String> expected = new ArrayList<>();
        expected.add(user4.getUsername());
        expected.add(user2.getUsername());
        expected.add(user1.getUsername());
        expected.add(user5.getUsername());
        expected.add(user3.getUsername());
        Assertions.assertEquals(expected, helper.getList());
    }
}
