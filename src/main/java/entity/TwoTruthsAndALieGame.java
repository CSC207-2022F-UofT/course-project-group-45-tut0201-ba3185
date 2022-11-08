package entity;

import java.sql.Statement;

public class TwoTruthsAndALieGame {

    private TwoTruthsAndALiePlayer[] players;

    public TwoTruthsAndALieGame(TwoTruthsAndALiePlayer player1, TwoTruthsAndALiePlayer player2) {
        this.players = new TwoTruthsAndALiePlayer[]{player1, player2};
    }

    public void saveStatements(TwoTruthsAndALiePlayer player, TwoTruthsAndALieStatements statements) {
        player.setStatements(statements);
    }

    public TwoTruthsAndALieStatements loadStatements(TwoTruthsAndALiePlayer player) {
        return player.getStatements();
    }

    public TwoTruthsAndALiePlayer[] getPlayers() {
        return players;
    }
}
