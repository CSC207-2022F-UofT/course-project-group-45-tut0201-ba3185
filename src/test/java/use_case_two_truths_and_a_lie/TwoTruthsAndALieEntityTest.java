package use_case_two_truths_and_a_lie;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.TwoTruthsAndALieStatements;
import entity.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TwoTruthsAndALieEntityTest {

    private TwoTruthsAndALiePlayer player1;
    private TwoTruthsAndALiePlayer player2;

    private TwoTruthsAndALieGame game;

    @BeforeEach
    void constructor() {
        this.player1 = new TwoTruthsAndALiePlayer(new User());
        this.player2 = new TwoTruthsAndALiePlayer(new User());
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
}
