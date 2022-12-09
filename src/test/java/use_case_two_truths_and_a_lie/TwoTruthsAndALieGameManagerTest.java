package use_case_two_truths_and_a_lie;
import database.csvManager;
import entity.TwoTruthsAndALieGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.List;

public class TwoTruthsAndALieGameManagerTest {
    private List<TwoTruthsAndALieGame> gameList;

    @BeforeEach
    public void initializeTest() throws IOException {
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
}
