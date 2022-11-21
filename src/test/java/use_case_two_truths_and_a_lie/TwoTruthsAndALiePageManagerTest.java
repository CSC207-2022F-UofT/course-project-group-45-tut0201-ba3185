package use_case_two_truths_and_a_lie;
import entity.User;
import presenter.TwoTruthsAndALiePagePresenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class TwoTruthsAndALiePageManagerTest {
    private TwoTruthsAndALiePageManager manager;

    @BeforeEach
    public void createManager() {
        TwoTruthsAndALiePageOutputBoundary presenter = new TwoTruthsAndALiePagePresenter();
        this.manager = new TwoTruthsAndALiePageManager();
    }

    @Test
    public void createGame() {

        Assertions.assertEquals(0, this.manager.getGames().size());

        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();

        User currentUser = new User();
        requestModel.setCurrentUser(currentUser);
        User otherUser = new User();
        requestModel.setOtherUser(otherUser);

        // this.manager.createGame();

        Assertions.assertEquals(1, this.manager.getGames().size());
    }
}
