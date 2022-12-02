package controller;

import gui.DiscoveryPanel;
import use_case_discovery.DiscoveryListPresenter;
import use_case_discovery.SearchAnswerRequestModel;
import use_case_discovery.SearchInteractor;
import use_case_discovery.SearchInputBoundary;

import java.util.ArrayList;
import java.util.List;

public class SearchController {
    private List<Integer> userAnswer;
    private SearchAnswerRequestModel requestModel = new SearchAnswerRequestModel();
    private SearchInputBoundary interactor;

    public SearchController(List<Integer> userAnswer, SearchInputBoundary interactor){
        this.userAnswer = userAnswer;
        this.interactor = interactor;
    }

    public void matchAnswer(){
        requestModel.setIncomeLow(userAnswer.get(0));
        requestModel.setIncomeUp(userAnswer.get(1));
        requestModel.setAgeLow(userAnswer.get(2));
        requestModel.setAgeUp(userAnswer.get(3));
        requestModel.setMarriageStateOP(userAnswer.get(4));
        requestModel.setAreaOfInterestOp(userAnswer.get(5));
        requestModel.setRelationshipOp(userAnswer.get(6));
        requestModel.setPetOp(userAnswer.get(7));
    }

    /**
     * This method create a new searchInteractor and calls the method
     * to generate the list based on the answer user enters.
     *
     */
    public void generateRecommendation(){
        interactor.recommendListGenerator(requestModel);
    }
}
