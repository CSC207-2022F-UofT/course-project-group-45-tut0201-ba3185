package controller;

import use_case_discovery.SearchAnswerRequestModel;
import use_case_discovery.UserInfoInputBoundary;
import use_case_discovery.UserInfoRequestModel;

public class UserInfoController {

    private final UserInfoRequestModel requestModel = new UserInfoRequestModel();

    UserInfoInputBoundary interactor;

    public UserInfoController(String username, UserInfoInputBoundary interactor){
        requestModel.setUsername(username);
        this.interactor = interactor;
    }

    public void findInfo(){
        this.interactor.create(requestModel);
    }


}
