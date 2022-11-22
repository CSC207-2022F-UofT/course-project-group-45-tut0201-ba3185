package controller;

import use_case_discovery.SearchAnswerRequestModel;
import use_case_discovery.SearchAsker;
import use_case_discovery.SearchFinder;
import use_case_discovery.SearchFinderInputBoundary;

import java.util.ArrayList;

public class SearchController {
    private ArrayList<Integer> userAnswer;
    private SearchFinderInputBoundary searchFinder;
    private SearchAnswerRequestModel requestModel = new SearchAnswerRequestModel();

    public SearchController(ArrayList<Integer> userAnswer){

        this.userAnswer = userAnswer;
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
     * This method create a new searchFinder and calls the method
     * to generate the list based on the answer user enters.
     *
     */
    public void generateRecommendation(){
        this.searchFinder = new SearchFinder(requestModel);;
        searchFinder.recommendListGenerator();
    }
}
