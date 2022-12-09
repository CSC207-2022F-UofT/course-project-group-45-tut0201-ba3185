package use_case_two_truths_and_a_lie;
import database.csvManager;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.TwoTruthsAndALieStatements;
import entity.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.List;

public class TwoTruthsAndALieEntityTest {

    private TwoTruthsAndALiePlayer player1;
    private TwoTruthsAndALiePlayer player2;

    private TwoTruthsAndALieGame game;

    private List<TwoTruthsAndALieGame> gameList;

    @BeforeEach
    void initializeTest() throws IOException {

        this.gameList = new csvManager().readGames();

        UserRequestModel userInfo = new csvManager().readCurrentUser();
        this.player1 = new TwoTruthsAndALiePlayer(new User(userInfo.getUsername(), userInfo.getName(), userInfo.getPassword(),
                                                            userInfo.getLocation(), userInfo.getUserSetting(), userInfo.getInterestRank(),
                                                            userInfo.getAreaOfInterest()));
        this.player2 = new TwoTruthsAndALiePlayer(new User("bob", "bob", "bob",
                userInfo.getLocation(), userInfo.getUserSetting(), userInfo.getInterestRank(),
                userInfo.getAreaOfInterest()));
        this.game = new TwoTruthsAndALieGame(player1, player2);
    }
    
    @Test
    void saveStatements() {
        TwoTruthsAndALieStatements statements = new TwoTruthsAndALieStatements("This is a truth.",
                                                                               "This is a truth also.",
                                                                                  "This is a lie.");
        this.game.saveStatements(this.player1, statements);

        TwoTruthsAndALieStatements savedStatements = this.player1.getStatements();

        Assertions.assertEquals(savedStatements.getTruth1(), "This is a truth.");
        Assertions.assertEquals(savedStatements.getTruth2(), "This is a truth also.");
        Assertions.assertEquals(savedStatements.getLie(), "This is a lie.");
    }

    @Test
    void loadStatements() {
        TwoTruthsAndALieStatements statements = new TwoTruthsAndALieStatements("This is a truth.",
                "This is a truth.",
                "This is a lie.");
        this.game.saveStatements(this.player1, statements);
        Assertions.assertEquals(this.game.loadStatements(this.player1), statements);
    }

    @AfterEach
    void restoreDatabase() {
        new csvManager().writeGames(this.gameList);
    }
}
