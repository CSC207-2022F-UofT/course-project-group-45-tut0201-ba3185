package use_case_two_truths_and_a_lie;
import database.csvManager;
import entity.TwoTruthsAndALieGame;
import org.junit.jupiter.api.*;

import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.*;

public class TwoTruthsAndALiePageManagerTest {
    private TwoTruthsAndALiePageManager manager;
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
        this.manager = new TwoTruthsAndALiePageManager();
        this.gameList = new csvManager().readGames();
    }

    @Test
    public void createGameAndGetGame() throws IOException {
        int previousSize = this.manager.getGames().size();

        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();
        UserRequestModel userInfo = new csvManager().readCurrentUser();
        requestModel.setOtherUser(userInfo.getUsername());
        this.manager.createGame(requestModel);

        Assertions.assertEquals(previousSize + 1, this.manager.getGames().size());
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
