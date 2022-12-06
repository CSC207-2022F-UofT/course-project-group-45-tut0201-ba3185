package presenter;

import gui.FrontPagePanel;
import use_case_frontpage.FrontPageOutputBoundary;
import use_case_frontpage.FrontPageResponseModel;

import java.util.ArrayList;

public class FrontPagePresenter implements FrontPageOutputBoundary {
    /**
     * The presenter that implements the OutputBoundary to return the view model
     * to UI to show the user the updates of their prior chat targets on the front page.
     *
     */
    FrontPagePanel frontPage;
    public FrontPagePresenter (FrontPagePanel frontPagePanel){
        this.frontPage = frontPagePanel;
    }
    public void create(FrontPageResponseModel responseModel){
        ArrayList<String> targetIdList = responseModel.getTargetUsers();

        for (String i : targetIdList) {
            frontPage.loadUser(i);
        }
    }
}