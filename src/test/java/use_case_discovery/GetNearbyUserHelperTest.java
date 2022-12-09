package use_case_discovery;

import database.csvManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.discovery.GetNearbyUserHelper;

import java.util.*;

public class GetNearbyUserHelperTest {
    GetNearbyUserHelper helper;

    @BeforeEach
    public void setUp() {
        csvManager manager = new csvManager();
        List<Double> location = new ArrayList<>(Arrays.asList(-79.39653244306562,43.66082236600782));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                "interests", "relationship type", "pet"));
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("gender", "male");
        userInfo.put("income", 124124);
        userInfo.put("age", 124124);
        userInfo.put("maritalStatus", "single");
        userInfo.put("relationshipType", "friend");
        userInfo.put("pet", "yes");
        userInfo.put("sexualOrientation", "male");
        manager.writeCurrentUser("sunny", "sunny", "sunny", location, userInfo, interestRank,
                "sport");
        helper = new GetNearbyUserHelper();
    }


    @Test
    public void testGetList(){
        List<String> correctList = Arrays.asList("ben", "nick", "ian",
                "leo", "gavin", "chen", "author", "ming", "eric", "heyy", "jack",
                "daniel", "henry", "oliver", "finch");
        List<String> generatedList = helper.getList();
        Assertions.assertEquals(correctList, generatedList);

    }
    @AfterAll
    public static void cleanup() {
        csvManager manager = new csvManager();
        manager.logoutUser();
    }

}

