package use_case_two_truths_and_a_lie;
import database.csvManager;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.User;
import presenter.TwoTruthsAndALiePagePresenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.List;


public class TwoTruthsAndALiePageManagerTest {
    private TwoTruthsAndALiePageManager manager;

    @BeforeEach
    public void createManager() {
        this.manager = new TwoTruthsAndALiePageManager();
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


}
