package usecase;

import java.util.ArrayList;

import Presenter.NearbyUserPresenter;
import entity.User;
import entity.Users;


public class LocationFinder implements LocationFinderInputBoundary{
    //the location of the current user
    Users users;
    //The current user
    User currentUser;
    LocationFinderOutputBoundary presenter;

    //constructor
    public LocationFinder(){
        users = new Users();
        currentUser = users.getCurrentUser();
        this.presenter = new NearbyUserPresenter();
    }

    GenderFinder temGenderFinder = new GenderFinder();
    ArrayList<User> userList = temGenderFinder.getList();

    GetNearbyUserHelper helper = new GetNearbyUserHelper(currentUser, userList);
    LocationFinderResponseModel responseModel = new LocationFinderResponseModel(helper.getNearbyUser());
    public void recommendListGenerator(){
        presenter.displayList(responseModel);
    }
}
