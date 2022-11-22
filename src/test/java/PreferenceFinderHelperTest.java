
import Discovery.DiscoveryUseCase.PreferenceFinderHelper;
import User.UserForTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;

public class PreferenceFinderHelperTest {
    UserForTest user1;
    UserForTest user2;
    UserForTest user3;
    UserForTest user4;
    UserForTest user5;
    UserForTest user6;
    ArrayList<String> mainUserInterestRank = new ArrayList<>(Arrays.asList("income", "pet", "marryStatus", "areaOfInterest", "age", "relationshipType"));

    @Before
    public void setUp() {
        //same as mainUser
        ArrayList<String> lst1 = new ArrayList<String>(Arrays.asList("income", "pet", "marryStatus", "areaOfInterest", "age", "relationshipType"));
        //completely opposite
        ArrayList<String> lst2 = new ArrayList<String>(Arrays.asList("relationshipType", "age", "areaOfInterest", "marryStatus", "pet", "income"));
        //with more than 2 same as mainUser
        ArrayList<String> lst3 = new ArrayList<String>(Arrays.asList("income", "pet", "areaOfInterest", "age", "marryStatus", "relationshipType"));
        //with 1(less than 2) same as mainUser
        ArrayList<String> lst4 = new ArrayList<String>(Arrays.asList("income", "age", "areaOfInterest", "marryStatus", "relationshipType", "pet"));
        //with exactly 2
        ArrayList<String> lst5 = new ArrayList<String>(Arrays.asList("income", "age", "areaOfInterest", "marryStatus", "pet", "relationshipType"));
        //with exactly 1
        ArrayList<String> lst6 = new ArrayList<String>(Arrays.asList("relationshipType", "age", "marryStatus", "pet", "areaOfInterest", "income"));

        user1 = new UserForTest("cami", "cami", "111", "Female", "Male");
        user1.setInterestRank(lst1);

        user2 = new UserForTest("chris", "chris", "222", "Female", "Male");
        user2.setInterestRank(lst2);

        user3 = new UserForTest("amber", "amber", "333", "Female", "Male");
        user3.setInterestRank(lst3);

        user4 = new UserForTest("sunny", "sunny", "333", "Male", "Female");
        user4.setInterestRank(lst4);

        user5 = new UserForTest("eric", "eric", "333", "Male", "Female");
        user5.setInterestRank(lst5);

        user6 = new UserForTest("jeniffer", "jeniffer", "333", "Female", "Male");
        user6.setInterestRank(lst6);
    }
    @Test
    public void allSameCaseTest() {
        PreferenceFinderHelper pfh = new PreferenceFinderHelper(user1, mainUserInterestRank);
        Assertions.assertEquals(22, pfh.getScore());
    }
    @Test
    public void allDifferentCaseTest() {
        PreferenceFinderHelper pfh = new PreferenceFinderHelper(user2, mainUserInterestRank);
        Assertions.assertEquals(0, pfh.getScore());
    }
    @Test
    public void MoreThanTwoCaseTest() {
        PreferenceFinderHelper pfh = new PreferenceFinderHelper(user3, mainUserInterestRank);
        Assertions.assertEquals(13, pfh.getScore());
    }
    @Test
    public void WithOneCaseTest() {
        PreferenceFinderHelper pfh = new PreferenceFinderHelper(user4, mainUserInterestRank);
        Assertions.assertEquals(6, pfh.getScore());
    }
    @Test
    public void WithTwoCaseTest() {
        PreferenceFinderHelper pfh = new PreferenceFinderHelper(user5, mainUserInterestRank);
        Assertions.assertEquals(7, pfh.getScore());
    }



}
