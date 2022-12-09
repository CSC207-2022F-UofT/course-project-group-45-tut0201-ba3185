package use_case_discovery;

import database.csvManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.discovery.PreferenceListHelper;

import java.util.*;



public class PreferenceListHelperTest {

    PreferenceListHelper plh;

    @BeforeEach
    public void setUp() {
        csvManager manager = new csvManager();
        List<Double> location = new ArrayList<>(Arrays.asList(14.5,14.5));
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
        plh = new PreferenceListHelper();
    }


    @Test
    public void testGetList(){
        List<String> correctList = Arrays.asList("author", "chen", "oliver",
                "eric", "heyy", "jack", "leo", "ming", "nick", "gavin", "henry",
                "ian", "ben", "daniel", "finch");
        List<String> generatedList = plh.getList();
        Assertions.assertEquals(correctList, generatedList);

    }

    @AfterAll
    public static void cleanup() {
        csvManager manager = new csvManager();
        manager.logoutUser();
    }
}