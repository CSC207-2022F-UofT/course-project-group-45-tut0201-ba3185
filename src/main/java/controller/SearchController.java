package controller;

import use_case_discovery.SearchAnswerRequestModel;
import use_case_discovery.SearchAsker;
import use_case_discovery.SearchFinder;
import use_case_discovery.SearchFinderInputBoundary;

import java.util.ArrayList;

public class SearchController {
    private ArrayList<Integer> userAnswer;
    private SearchFinderInputBoundary searchFinder;

    public SearchController(ArrayList<Integer> userAnswer, SearchFinderInputBoundary searchFinder){

        this.userAnswer = userAnswer;
        this.searchFinder = searchFinder;
    }

    public void matchAnswer(){
        SearchAnswerRequestModel requestModel = new SearchAnswerRequestModel();
        requestModel.setIncomeLow(userAnswer.get(0));
        requestModel.setIncomeUp(userAnswer.get(1));
        requestModel.setAgeLow(userAnswer.get(2));
        requestModel.setAgeUp(userAnswer.get(3));
        requestModel.setMarriageStateOP(userAnswer.get(4));
        requestModel.setAreaOfInterestOp(userAnswer.get(5));
        requestModel.setRelationshipOp(userAnswer.get(6));
        requestModel.setPetOp(userAnswer.get(7));
    }

    public void generateRecommendation(){
        searchFinder.recommendListGenerator();
    }
}
