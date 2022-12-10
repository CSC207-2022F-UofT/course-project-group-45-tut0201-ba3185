package use_case_User_Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import use_case.signin_signup.UserRequestModel;
import use_case.signin_signup.UserUseCase;

import java.util.*;

public class use_case_User_Test {

    static UserUseCase useCase;

    @BeforeEach
    public void setup() {
        List<Double> location = new ArrayList<>(Arrays.asList(14.5,14.5));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                "interests", "relationship type", "pet"));

        UserRequestModel requestModel1 = new UserRequestModel();
        requestModel1.setInfo("test","test", "test", 14, 124,"male",
                "friend", "single", "yes", location, "female",
                interestRank, "sport");

        UserRequestModel requestModel2 = new UserRequestModel();
        requestModel2.setInfo("test2","test2", "test2", 15, 12234,"male",
                "friend", "married", "no", location, "female",
                interestRank, "game");

        UserRequestModel requestModel3 = new UserRequestModel();
        requestModel3.setInfo("test3","test3", "test3", 14, 14,"female",
                "friend", "single", "yes", location, "bisexual",
                interestRank, "sport");

        Map<String, UserRequestModel> userMap = new HashMap<>();
        userMap.put("test", requestModel1);
        userMap.put("test2", requestModel2);
        userMap.put("test3", requestModel3);
        useCase = new UserUseCase(userMap);
    }

    @Test
    public void testExisitingUser() {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("gender", "male");
        userInfo.put("income", 141);
        userInfo.put("age", 142);
        userInfo.put("maritalStatus", "single");
        userInfo.put("relationshipType", "friend");
        userInfo.put("pet", true);
        userInfo.put("sexualOrientation", "female");

        List<Double> location = new ArrayList<>(Arrays.asList(14.5,14.5));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                "interests", "relationship type", "pet"));

        Assertions.assertAll("should return true",
                () -> Assertions.assertFalse(useCase.addUser("tester", "test3", "password",
                        location, userInfo, interestRank, "sport")),
                () -> Assertions.assertTrue(useCase.addUser("tester", "test4", "password",
                        location, userInfo, interestRank, "sport")));
    }

    @Test
    public void testUserExists() {
        Assertions.assertAll("should return true if users exist",
                () -> Assertions.assertTrue(useCase.userExists("test")),
                () -> Assertions.assertTrue(useCase.userExists("test2")),
                () -> Assertions.assertTrue(useCase.userExists("test3")),
                () -> Assertions.assertFalse(useCase.userExists("test5")));
    }

    @Test
    public void testGetUserPassword() {
        Assertions.assertEquals("test3", useCase.getUserPassword("test3"));
        Assertions.assertEquals("test2", useCase.getUserPassword("test2"));
    }
}
