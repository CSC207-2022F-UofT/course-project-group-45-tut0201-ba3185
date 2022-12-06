package controller;
import entity.TwoTruthsAndALieGame;
import entity.User;
import use_case_two_truths_and_a_lie.TwoTruthsAndALieGameInputBoundary;
import use_case_two_truths_and_a_lie.TwoTruthsAndALieGameManager;
import use_case_two_truths_and_a_lie.TwoTruthsAndALieGameRequestModel;

public class TwoTruthsAndALieGameController {
    private TwoTruthsAndALieGameInputBoundary manager;

    public TwoTruthsAndALieGameController() {
        this.manager = new TwoTruthsAndALieGameManager();
    }

    public void showInput(T

    public void submitStatements(TwoTruthsAndALieGame game, String truth1, String truth2, String lie) {
        TwoTruthsAndALieGameRequestModel requestModel = new TwoTruthsAndALieGameRequestModel();
        requestModel.setGame(game);
        requestModel.setTruth1(truth1);
        requestModel.setTruth2(truth2);
        requestModel.setLie(lie);
        manager.saveStatements(requestModel);
    }

    public void submitAnswer(TwoTruthsAndALieGame game, String answer) {
        TwoTruthsAndALieGameRequestModel requestModel = new TwoTruthsAndALieGameRequestModel();
        requestModel.setGame(game);
        requestModel.setChosenStatement(answer);
        manager.isCorrect(requestModel);
    }

}
