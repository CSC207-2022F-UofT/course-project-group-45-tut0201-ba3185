package entity_test;

import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import use_case.signin_signup.UserRequestModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFactoryTest {

    static UserFactory factory;

    @BeforeAll
    public static void setup() {
        factory = new UserFactory();
    }

    @Test
    public void testCreate() {
        List<Double> location = new ArrayList<>(Arrays.asList(14.5,14.5));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                "interests", "relationship type", "pet"));

        UserRequestModel requestModel1 = new UserRequestModel();
        requestModel1.setInfo("test","test", "test", 14, 124,"male",
                "friend", "single", "yes", location, "female",
                interestRank, "sport");

        User createdUser = factory.create(requestModel1);
        Assertions.assertEquals("test", createdUser.getName());
        Assertions.assertEquals("test", createdUser.getUsername());
        Assertions.assertEquals("single", createdUser.getUserInfo("maritalStatus"));
        Assertions.assertEquals(14, createdUser.getUserInfo("age"));
    }
}
