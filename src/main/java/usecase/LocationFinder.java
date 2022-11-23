package usecase;

import java.util.ArrayList;

import Presenter.NearbyUserPresenter;
import UI.NearbyUserInterface;
import entity.User;
import entity.Users;


public class LocationFinder implements LocationFinderInputBoundary{
    //the location of the current user
    Users users;
    //The current user
    User currentUser;
    LocationFinderOutputBoundary presenter;

    NearbyUserInterface panel;


    //constructor
    public LocationFinder(NearbyUserInterface panel){
        this.panel = panel;
        users = new Users();
        currentUser = users.getCurrentUser();
    }

    GenderFinder temGenderFinder = new GenderFinder();
    ArrayList<User> userList = temGenderFinder.getList();
    GetNearbyUserHelper helper = new GetNearbyUserHelper(currentUser, userList);

    public void recommendListGenerator(){
        LocationFinderResponseModel responseModel = new LocationFinderResponseModel();
        responseModel.setRecommendList(helper.getNearbyUser());
        presenter = new NearbyUserPresenter(panel, responseModel);
        presenter.displayList();
    }
}