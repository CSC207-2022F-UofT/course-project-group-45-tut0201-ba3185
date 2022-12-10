package use_case_two_truths_and_a_lie;
import database.csvManager;
import entity.TwoTruthsAndALieGame;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.two_truths_and_a_lie.TwoTruthsAndALiePageManager;
import use_case.two_truths_and_a_lie.TwoTruthsAndALiePageRequestModel;
import use_case.signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.*;
public class TwoTruthsAndALieGameManagerTest {
    private List<TwoTruthsAndALieGame> gameList;

    @BeforeEach
    public void initializeTest() throws IOException {
        csvManager manager = new csvManager();
        List<Double> location = new ArrayList<>(Arrays.asList(14.5,14.5));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                "interests", "relationship type", "pet"));
        Map<String, Object> userInfo1 = new HashMap<>();
        userInfo1.put("income", 141);
        userInfo1.put("age", 142);
        userInfo1.put("gender", "male");
        userInfo1.put("relationshipType", "friend");
        userInfo1.put("pet", true);
        userInfo1.put("maritalStatus", "single");
        userInfo1.put("sexualOrientation", "female");
        manager.writeCurrentUser("sunny", "sunny", "sunny", location, userInfo1, interestRank,
                "sport");
        this.gameList = new csvManager().readGames();
    }

    @Test
    public void createManagerAndGame() throws IOException {
        TwoTruthsAndALiePageManager pageManager = new TwoTruthsAndALiePageManager();
        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();
        UserRequestModel userInfo = new csvManager().readCurrentUser();
        requestModel.setOtherUser(userInfo.getUsername());
        pageManager.createGame(requestModel);
    }

    @AfterEach
    void restoreDatabase() {
        new csvManager().writeGames(this.gameList);
    }

    @AfterAll
    public static void cleanup() {
        csvManager manager = new csvManager();
        manager.logoutUser();
    }
}
