import entity.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class UserTest {

    static User tester;

    @BeforeClass
    public static void setup(){
        List<Double> location = new ArrayList<>(Arrays.asList(14.5,14.5));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                            "interests", "relationship type", "pet"));
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("gender", "male");
        userInfo.put("income", 141);
        userInfo.put("age", 142);
        userInfo.put("maritalStatus", "single");
        userInfo.put("relationshipType", "friend");
        userInfo.put("pet", true);
        userInfo.put("sexualOrientation", "female");
        tester = new User("tester", "tester", "password", location, userInfo, interestRank,
                "sport");
    }

    @Test
    public void testName() {
        Assertions.assertEquals("tester", tester.getName());
    }
}
