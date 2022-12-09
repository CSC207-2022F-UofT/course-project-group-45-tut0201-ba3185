package use_case_discovery;

import database.csvManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.*;


public class GenderInteractorTest {
    GenderInteractor gi;

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
        gi = new GenderInteractor();
    }


    @Test
    public void testGetList(){
        List<String> correctList = Arrays.asList("heyy", "author", "ben","chen",
                "daniel","eric","finch","gavin","henry","ian","jack","leo","ming",
                "nick","oliver");
        Collections.sort(correctList);
        List<String> generatedList = gi.getList();
        Collections.sort(generatedList);
        Assertions.assertEquals(correctList, generatedList);

    }

    @AfterAll
    public static void cleanup() {
        csvManager manager = new csvManager();
        manager.logoutUser();
    }
}