package controller;
import entity.User;
import gui.TwoTruthsAndALiePagePanelInterface;
import use_case_two_truths_and_a_lie.TwoTruthsAndALiePageInputBoundary;
import use_case_two_truths_and_a_lie.TwoTruthsAndALiePageManager;
import use_case_two_truths_and_a_lie.TwoTruthsAndALiePageRequestModel;
import use_case_two_truths_and_a_lie.TwoTruthsAndALiePageResponseModel;

import javax.swing.*;

public class TwoTruthsAndALiePageController {

    private TwoTruthsAndALiePageInputBoundary manager;

    public TwoTruthsAndALiePageController() {
        this.manager = new TwoTruthsAndALiePageManager();
    }

    public void createGame(TwoTruthsAndALiePagePanelInterface panel) {
        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();
        requestModel.setPanel(panel);
        manager.createGame(requestModel);
    }

    public void showUserGames(TwoTruthsAndALiePagePanelInterface panel) {
        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();
        requestModel.setPanel(panel);
        manager.loadUserGames(requestModel);
    }
}
