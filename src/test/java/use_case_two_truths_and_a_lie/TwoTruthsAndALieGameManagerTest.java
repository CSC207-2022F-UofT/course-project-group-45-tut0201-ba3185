package use_case_two_truths_and_a_lie;
import database.csvManager;
import org.junit.jupiter.api.Test;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;

public class TwoTruthsAndALieGameManagerTest {
    private TwoTruthsAndALieGameManager gameManager;
    private TwoTruthsAndALiePageManager pageManager;

    @Test
    public void createManagerAndGame() throws IOException {
        this.gameManager = new TwoTruthsAndALieGameManager("sunny");
        this.pageManager = new TwoTruthsAndALiePageManager();
        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();
        UserRequestModel userInfo = new csvManager().readCurrentUser();
        requestModel.setOtherUser(userInfo.getUsername());
        this.pageManager.createGame(requestModel);
    }
}
