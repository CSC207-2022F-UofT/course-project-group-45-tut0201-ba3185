package presenter;

import gui.chat.FrontPagePanel;
import use_case.frontpage.FrontPageOutputBoundary;
import use_case.frontpage.FrontPageResponseModel;

import java.util.List;

public class FrontPagePresenter implements FrontPageOutputBoundary {
    /**
     * The presenter that implements the OutputBoundary to display all prior chat targets
     * of the user on the front page.
     *
     */
    FrontPagePanel frontPage;
    public FrontPagePresenter (FrontPagePanel frontPagePanel){
        this.frontPage = frontPagePanel;
    }
    public void create(FrontPageResponseModel responseModel){
        List<String> targetIdList = responseModel.getTargetUsers();

        for (String i : targetIdList) {
            frontPage.loadUser(i);
        }
    }
}