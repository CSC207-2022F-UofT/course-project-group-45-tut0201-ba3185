package presenter;

import use_case_frontpage.FrontPageOutputBoundary;
import use_case_frontpage.FrontPageResponseModel;
import use_case_frontpage.FrontPageViewModel;

import java.util.ArrayList;

public class FrontPagePresenter implements FrontPageOutputBoundary {
    @Override
    public FrontPageViewModel create(FrontPageResponseModel responseModel){
        ArrayList<String> targetIdList = responseModel.getTargetUsers();
        return new FrontPageViewModel(targetIdList);
    }
}