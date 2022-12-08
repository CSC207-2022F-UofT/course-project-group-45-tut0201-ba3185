package controller;

import use_case_frontpage.FrontPageInputBoundary;
import use_case_frontpage.FrontPageRequestModel;

public class FrontPageController {
    /**
     * The controller of frontpage that converts the request of adding a new target
     * to a request model and passes it to the interactor
     *
     */
    final FrontPageInputBoundary frontPageInputBoundary;

    public FrontPageController(FrontPageInputBoundary frontPageInputBoundary){
        this.frontPageInputBoundary = frontPageInputBoundary;
    }

    public void create(){
        FrontPageRequestModel frontPageRequestModel = new FrontPageRequestModel();
        this.frontPageInputBoundary.create(frontPageRequestModel);
    }

    public void create(String target){
        FrontPageRequestModel frontPageRequestModel = new FrontPageRequestModel(target);
        this.frontPageInputBoundary.create(frontPageRequestModel);
    }
}
