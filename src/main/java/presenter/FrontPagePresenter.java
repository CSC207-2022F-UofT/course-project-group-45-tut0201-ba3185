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
    public void create(FrontPageResponseModel responseModel){
        ArrayList<String> targetIdList = responseModel.getTargetUsers();

        FrontPagePanel frontPage = new FrontPagePanel();
        for (String i : targetIdList) {
            frontPage.loadUser(i);
        }
    }
}