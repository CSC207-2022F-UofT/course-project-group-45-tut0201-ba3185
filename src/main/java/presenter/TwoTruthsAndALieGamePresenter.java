package presenter;
import database.csvManager;
import gui.game.TwoTruthsAndALieGamePanelInterface;
import use_case_two_truths_and_a_lie.TwoTruthsAndALieGameManager;
import use_case_two_truths_and_a_lie.TwoTruthsAndALieGameOutputBoundary;
import use_case_two_truths_and_a_lie.TwoTruthsAndALieGameRequestModel;
import use_case_two_truths_and_a_lie.TwoTruthsAndALieGameResponseModel;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


/**
 * The `TwoTruthsAndALieGamePresenter` class is a concrete implementation of the `TwoTruthsAndALieGameOutputBoundary`
 * interface. It is a presenter responsible for presenting a game of Two Truths and a Lie to the user.
 *
 * @author Eric Xue
 * @see TwoTruthsAndALieGameOutputBoundary
 */
public class TwoTruthsAndALieGamePresenter implements TwoTruthsAndALieGameOutputBoundary {

    private TwoTruthsAndALieGamePanelInterface view;
    private TwoTruthsAndALieGameManager manager;

    public TwoTruthsAndALieGamePresenter(TwoTruthsAndALieGamePanelInterface view, String otherUser) throws IOException {
        this.view = view;
        this.manager = new TwoTruthsAndALieGameManager(otherUser);
    }

    public void update() {
        String state = manager.getGameState();
        if (Objects.equals(state, "entering")) {
            view.showInputFields(manager.findOtherPlayer().getUser().getUsername());
        }
        else if (Objects.equals(state, "waiting")) {
            view.showWaiting(manager.findOtherPlayer().getUser().getUsername());
        }
        else {
            List<String> statements = manager.getOtherPlayerStatementStrings();
            view.showChoices(manager.findOtherPlayer().getUser().getUsername(), statements);
        }
    }

    public void saveStatements(List<String> statements) throws IOException {
        TwoTruthsAndALieGameRequestModel requestModel = new TwoTruthsAndALieGameRequestModel();
        requestModel.setTruth1(statements.get(0));
        requestModel.setTruth2(statements.get(1));
        requestModel.setLie(statements.get(2));
        manager.saveStatements(requestModel);
        this.update();
    }

    public void submitChoice(String text, String otherUser) throws IOException {
        TwoTruthsAndALieGameRequestModel requestModel = new TwoTruthsAndALieGameRequestModel();
        requestModel.setChosenStatement(text);
        TwoTruthsAndALieGameResponseModel responseModel = manager.isCorrect(requestModel);
        if (responseModel.isCorrect()) {
            view.showWin();
            new csvManager().deleteGame(otherUser);
        }
        else {
            view.showLose();
            new csvManager().deleteGame(otherUser);
        }
    }
}
