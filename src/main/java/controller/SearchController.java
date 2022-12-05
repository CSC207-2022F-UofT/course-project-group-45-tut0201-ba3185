package controller;

import use_case_discovery.SearchAnswerRequestModel;
import use_case_discovery.SearchInputBoundary;

import java.util.List;

/**
 * This is the controller for search discovery
 * It triggers the search Interactor and pass user's answer
 * through a request model.
 */
public class SearchController {
    private final SearchAnswerRequestModel requestModel = new SearchAnswerRequestModel();
    private final SearchInputBoundary interactor;

    public SearchController(List<Integer> userAnswer, SearchInputBoundary interactor){
        this.interactor = interactor;
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
     * This method calls the method to generate the list based on the answer user enters.
     *
     */
    public void generateRecommendation(){
        this.interactor.recommendListGenerator(requestModel);
    }
}
