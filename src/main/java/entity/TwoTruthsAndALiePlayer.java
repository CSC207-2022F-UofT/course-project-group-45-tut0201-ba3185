package entity;

public class TwoTruthsAndALiePlayer {
    private User user;
    private TwoTruthsAndALieStatements statements;

    public TwoTruthsAndALiePlayer(User user) {
        this.user = user;
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
