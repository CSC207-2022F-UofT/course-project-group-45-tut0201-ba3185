package presenter;

import use_case_frontpage.FrontPageOutputBoundary;
import use_case_frontpage.FrontPageResponseModel;
import use_case_frontpage.FrontPageViewModel;

import java.util.ArrayList;

public class FrontPagePresenter implements FrontPageOutputBoundary {
    /**
     * The presenter that implements the OutputBoundary to return the view model
     * to UI to show the user the updates of their prior chat targets on the front page.
     *
     * @param responseModel the response model created by the interactor and passed
     *                      through outputBoundary to the presenter
     * @return the view model that is passed to the view for the result to be shown
     */
    @Override
    public FrontPageViewModel create(FrontPageResponseModel responseModel){
        ArrayList<String> targetIdList = responseModel.getTargetUsers();
        return new FrontPageViewModel(targetIdList);
    }
}