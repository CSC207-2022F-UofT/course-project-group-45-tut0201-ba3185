package use_case_two_truths_and_a_lie;
import database.csvManager;
import entity.TwoTruthsAndALieGame;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.List;


public class TwoTruthsAndALiePageManagerTest {
    private TwoTruthsAndALiePageManager manager;
    private List<TwoTruthsAndALieGame> gameList;

    @BeforeEach
    public void initializeTest() throws IOException {
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
}
