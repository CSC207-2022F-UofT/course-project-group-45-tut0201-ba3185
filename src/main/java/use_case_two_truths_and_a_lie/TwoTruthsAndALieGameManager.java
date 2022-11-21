package use_case_two_truths_and_a_lie;
import java.util.*;

import entity.*;
import presenter.TwoTruthsAndALieGamePresenter;


/**
 *  Use Case for Two Truths And A Lie Game
 *  Interacts with a single Two Truths and A Lie Game entity at a time
 *  @author  Eric Xue
 */
public class TwoTruthsAndALieGameManager implements TwoTruthsAndALieGameInputBoundary {
    private TwoTruthsAndALieGameOutputBoundary presenter;

    public TwoTruthsAndALieGameManager() {
        this.presenter = new TwoTruthsAndALieGamePresenter();
    }

    /**
     * Saves the statements that a user has inputted
     * Calls loadStatements() immediately to start fetching other player's statements
     */
    public void saveStatements(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALieStatements statements = new TwoTruthsAndALieStatements(
                                                    requestModel.getTruth1(),
                                                    requestModel.getTruth2(),
                                                    requestModel.getLie());
        TwoTruthsAndALiePlayer player = this.findPlayer(requestModel);
        requestModel.getGame().saveStatements(player, statements);
        loadStatements(requestModel);
    }

    /**
     * Loads the statements that the other user has inputted
     * If the other player has no statements, make the presenter display loading status
     * Otherwise, display the statements to the current player
     */
    public void loadStatements(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALiePlayer player = this.findPlayer(requestModel);
        TwoTruthsAndALieStatements statements = player.getStatements();
        if (statements != null) {
            presenter.showStatements(new String[]{statements.getTruth1(), statements.getTruth2(), statements.getLie()});
        }
        presenter.showWaitingForStatements();
    }

    public void isCorrect(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALiePlayer player = this.findPlayer(requestModel);
        presenter.showResult(Objects.equals(player.getStatements().getLie(), requestModel.getChosenStatement()));
    }

    /**
     * A helper method for finding the player entity given the current user and a game
     * @return TwoTruthsAndALiePlayer
     */
    public TwoTruthsAndALiePlayer findPlayer(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALiePlayer[] players = requestModel.getGame().getPlayers();
        TwoTruthsAndALiePlayer player;
        if (players[0].getUser() == requestModel.getCurrentUser()) {
            player = players[0];
        }
        else {
            player = players[1];
        }
        return player;
    }
}
