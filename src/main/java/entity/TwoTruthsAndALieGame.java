package entity;

import java.sql.Statement;

/**
 *  A Two Truths And A Lie Game Entity
 *  Keeps track of the details of a Two Truths And A Lie game, such as players. （Further detail is tracked within each player)
 *  @author  Eric Xue
 */
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
