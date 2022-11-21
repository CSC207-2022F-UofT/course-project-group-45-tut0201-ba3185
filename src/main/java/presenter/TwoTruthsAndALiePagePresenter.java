package presenter;

import entity.TwoTruthsAndALieGame;
import gui.TwoTruthsAndALiePagePanel;
import gui.TwoTruthsAndALiePagePanelViewModel;
import use_case_two_truths_and_a_lie.TwoTruthsAndALiePageOutputBoundary;
import use_case_two_truths_and_a_lie.TwoTruthsAndALiePageResponseModel;

import java.util.List;

public class TwoTruthsAndALiePagePresenter implements TwoTruthsAndALiePageOutputBoundary {

    @Override
    public void showGames(TwoTruthsAndALiePageResponseModel responseModel) {
        TwoTruthsAndALiePagePanelViewModel viewModel = new TwoTruthsAndALiePagePanelViewModel();
        viewModel.setGames(responseModel.getGames());
        responseModel.getPanel().update(viewModel);
    }
}