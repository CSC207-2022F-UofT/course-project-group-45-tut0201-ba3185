package controller;

import use_case.frontpage.FrontPageInputBoundary;
import use_case.frontpage.FrontPageRequestModel;

public class FrontPageController {
    /**
     * The controller of frontpage that converts the request of refreshing the front page
     * to a request model and passes it to the interactor
     */
    final FrontPageInputBoundary frontPageInputBoundary;

    public FrontPageController(FrontPageInputBoundary frontPageInputBoundary){
        this.frontPageInputBoundary = frontPageInputBoundary;
    }

    public void create(){
        FrontPageRequestModel frontPageRequestModel = new FrontPageRequestModel();
        this.frontPageInputBoundary.create(frontPageRequestModel);
    }
}
