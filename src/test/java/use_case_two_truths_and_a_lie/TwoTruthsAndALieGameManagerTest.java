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
        // this.gameManager = new TwoTruthsAndALieGameManager();
        this.pageManager = new TwoTruthsAndALiePageManager();
        // this.pageManager.createGame();
    }

    @Test
    void findPlayerTest() {

        TwoTruthsAndALieGameRequestModel requestModel = new TwoTruthsAndALieGameRequestModel();

        TwoTruthsAndALieGame game = this.pageManager.getGames().get(0);

        requestModel.setGame(game);
        requestModel.setCurrentUser(this.currentUser);

        TwoTruthsAndALiePlayer player = this.gameManager.findCurrentPlayer();

        Assertions.assertTrue(game.getPlayers()[0] == player || game.getPlayers()[1] == player);
    }
}
