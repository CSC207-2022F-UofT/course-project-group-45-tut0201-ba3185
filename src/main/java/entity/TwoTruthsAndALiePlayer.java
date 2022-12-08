package entity;

/**
 *  A Two Truths And A Lie Game Player
 *  Each player entity is unique; the player entity is specific to each Two Truths And A Lie Game
 *  This means a user are different players in different games
 *  Keeps track of the user behind the player and the player's statements
 *  @author  Eric Xue
 */
public class TwoTruthsAndALiePlayer {
    private User user;
    private TwoTruthsAndALieStatements statements;

    public TwoTruthsAndALiePlayer(User user) {
        this.user = user;
        this.setStatements(new TwoTruthsAndALieStatements("null", "null", "null"));
    }

    public User getUser() {
        return user;
    }

    public void setStatements(TwoTruthsAndALieStatements statements) {
        this.statements = statements;
    }

    public TwoTruthsAndALieStatements getStatements() {
        return statements;
    }
}
