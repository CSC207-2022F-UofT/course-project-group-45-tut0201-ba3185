package controller;

import use_case_frontpage.FrontPageRequestModel;

public class FrontPageController {
    /**
     * The controller of frontpage that converts the request of adding a new target
     * to a request model and passes it to the interactor.
     *
     * @param target the target user who the user talked to
     * @return the request model that will be passed to the interactor through
     * input boundary
     */
    public FrontPageRequestModel create(String target){
        return new FrontPageRequestModel(target);
    }

}
