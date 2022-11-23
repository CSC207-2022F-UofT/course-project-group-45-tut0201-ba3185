package Presenter;

import UI.NearbyUserInterface;
import UI.NearbyUserViewModel;
import usecase.LocationFinderOutputBoundary;
import usecase.LocationFinderResponseModel;

import java.util.ArrayList;

public class NearbyUserPresenter implements LocationFinderOutputBoundary {

    private NearbyUserInterface panel;
    private LocationFinderResponseModel responseModel;
    private NearbyUserViewModel viewModel;

    public NearbyUserPresenter(NearbyUserInterface panel, LocationFinderResponseModel responseModel){
        this.panel = panel;
        this.responseModel = responseModel;
        viewModel = new NearbyUserViewModel();
    }
    public void displayList(){
        ArrayList<String> usernames = responseModel.getRecommendList();

        int FRAME_WIDTH = 414;
        int FRAME_HEIGHT = 736;

        viewModel.setUserName1(usernames.get(0));
        viewModel.setUserName2(usernames.get(1));
        viewModel.setUserName3(usernames.get(2));
        viewModel.setUserName4(usernames.get(3));
        viewModel.setUserName5(usernames.get(4));
        viewModel.setUserName6(usernames.get(5));
        viewModel.setUserName7(usernames.get(6));
        viewModel.setUserName8(usernames.get(7));
        viewModel.setUserName9(usernames.get(8));
        viewModel.setUserName10(usernames.get(9));
        viewModel.setUserName11(usernames.get(10));
        viewModel.setUserName12(usernames.get(11));
        viewModel.setUserName13(usernames.get(12));
        viewModel.setUserName14(usernames.get(13));
        viewModel.setUserName15(usernames.get(14));

        panel.update(FRAME_WIDTH, FRAME_HEIGHT, viewModel);
    }
}