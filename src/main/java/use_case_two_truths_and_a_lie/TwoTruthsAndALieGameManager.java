package use_case_two_truths_and_a_lie;
import java.util.*;

import entity.*;

public class TwoTruthsAndALieGameManager implements TwoTruthsAndALieGameInputBoundary {
    private TwoTruthsAndALieGameOutputBoundary presenter;
    private TwoTruthsAndALieGameState gameState;
    public TwoTruthsAndALieGameManager(TwoTruthsAndALieGameOutputBoundary presenter) {
        this.presenter = presenter;
        gameState = new TwoTruthsAndALieGameState();
    }

    public void saveStatements(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALieStatements statements = new TwoTruthsAndALieStatements(
                                                    requestModel.getTruth1(),
                                                    requestModel.getTruth2(),
                                                    requestModel.getLie());
        TwoTruthsAndALiePlayer player = this.findPlayer(requestModel);
        requestModel.getGame().saveStatements(player, statements);
        gameState.setCurrentState(gameState.WAITING_OPP);
        loadStatements(requestModel);
    }

    public void loadStatements(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALiePlayer player = this.findPlayer(requestModel);
        TwoTruthsAndALieStatements statements = player.getStatements();
        if (statements != null) {
            gameState.setCurrentState(gameState.WAITING_SEL);
            presenter.showStatements(new String[]{statements.getTruth1(), statements.getTruth2(), statements.getLie()});
        }
        presenter.showWaitingForStatements();
    }

    public void isCorrect(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALiePlayer player = this.findPlayer(requestModel);
        gameState.setCurrentState(gameState.DISPLAYING_RES);
        presenter.showResult(Objects.equals(player.getStatements().getLie(), requestModel.getChosenStatement()));
    }

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
