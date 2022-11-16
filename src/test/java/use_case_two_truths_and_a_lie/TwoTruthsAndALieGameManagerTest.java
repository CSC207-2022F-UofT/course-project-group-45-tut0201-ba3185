package use_case_two_truths_and_a_lie;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.User;
import presenter.TwoTruthsAndALieGamePresenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import presenter.TwoTruthsAndALiePagePresenter;


public class TwoTruthsAndALieGameManagerTest {

    private TwoTruthsAndALieGameManager gameManager;
    private TwoTruthsAndALiePageManager pageManager;
    private User currentUser;

    @BeforeEach
    public void createManagerAndGame() {
        TwoTruthsAndALieGameOutputBoundary gamePresenter = new TwoTruthsAndALieGamePresenter();
        this.gameManager = new TwoTruthsAndALieGameManager(gamePresenter);

        TwoTruthsAndALiePageOutputBoundary pagePresenter = new TwoTruthsAndALiePagePresenter();
        this.pageManager = new TwoTruthsAndALiePageManager(pagePresenter);

        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();

        this.currentUser = new User();
        requestModel.setCurrentUser(this.currentUser);
        User otherUser = new User();
        requestModel.setOtherUser(otherUser);

        this.pageManager.createGame(requestModel);
    }

    @Test
    void findPlayerTest() {

        TwoTruthsAndALieGameRequestModel requestModel = new TwoTruthsAndALieGameRequestModel();

        TwoTruthsAndALieGame game = this.pageManager.getGames().get(0);

        requestModel.setGame(game);
        requestModel.setCurrentUser(this.currentUser);

        TwoTruthsAndALiePlayer player = this.gameManager.findPlayer(requestModel);

        Assertions.assertTrue(game.getPlayers()[0] == player || game.getPlayers()[1] == player);
    }
}
