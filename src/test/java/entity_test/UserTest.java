package entity_test;

import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

public class UserTest {

    static User tester;

    @BeforeAll
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
        tester = new User("tester", "test", "password", location, userInfo, interestRank,
                "sport");
    }

    @Test
    public void testName() {
        Assertions.assertEquals("test", tester.getName());
    }

    @Test
    public void testUsername() {
        Assertions.assertEquals("tester", tester.getUsername());
    }

    @Test
    public void testPassword() {
        Assertions.assertEquals("password", tester.getPassword());
    }

    @Test
    public void testLocation() {
        Assertions.assertEquals(Arrays.asList(14.5,14.5), tester.getLocation());
    }

    @Test
    public void testAreaOfInterest() {
        Assertions.assertEquals("sport", tester.getAreaOfInterest());
    }

    @Test
    public void testAllUserInfo() {
        String[] testKeys = {"gender", "income", "age", "pet", "relationshipType", "sexualOrientation",
                "maritalStatus"};
        List<Object> testValues = new ArrayList<>(Arrays.asList("male", 141, 142, true, "friend", "female", "single"));

        for(int i = 0; i< testValues.size(); i++) {
            Assertions.assertEquals(tester.getUserInfo(testKeys[i]), testValues.get(i));
        }
    }

    @Test
    public void testTwoUsers() {
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
        tester = new User("tester", "test", "password", location, userInfo, interestRank,
                "sport");

        User userTwo = new User("user2", "usertwo", "user", location, userInfo,
                interestRank, "sport");

        Assertions.assertNotEquals(userTwo, tester);
    }
}