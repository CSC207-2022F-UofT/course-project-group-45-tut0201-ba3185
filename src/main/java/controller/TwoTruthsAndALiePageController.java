package controller;
import entity.User;
import use_case_two_truths_and_a_lie.TwoTruthsAndALiePageInputBoundary;
import use_case_two_truths_and_a_lie.TwoTruthsAndALiePageRequestModel;

public class TwoTruthsAndALiePageController {

    private TwoTruthsAndALiePageInputBoundary manager;

    public TwoTruthsAndALiePageController(TwoTruthsAndALiePageInputBoundary manager) {
        this.manager = manager;
    }

    public void showUserGames(User user) {
        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();
        requestModel.setCurrentUser(user);
        manager.loadUserGames(requestModel);
    }
}
