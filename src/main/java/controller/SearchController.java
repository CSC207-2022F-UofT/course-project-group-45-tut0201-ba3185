package controller;

import use_case_discovery.SearchAnswerRequestModel;
import use_case_discovery.SearchInputBoundary;

import java.util.List;

public class SearchController {
    private List<Integer> userAnswer;
    private SearchAnswerRequestModel requestModel = new SearchAnswerRequestModel();
    private SearchInputBoundary interactor;

    public SearchController(List<Integer> userAnswer, SearchInputBoundary interactor){
        this.userAnswer = userAnswer;
        this.interactor = interactor;
        requestModel.setIncomeLow(this.userAnswer.get(0));
        System.out.println(requestModel.getIncomeLow());
        requestModel.setIncomeUp(this.userAnswer.get(1));
        System.out.println(requestModel.getIncomeUp());
        requestModel.setAgeLow(this.userAnswer.get(2));
        System.out.println(requestModel.getAgeLow());
        requestModel.setAgeUp(this.userAnswer.get(3));
        System.out.println(requestModel.getAgeUp());
        requestModel.setMarriageStateOP(this.userAnswer.get(4));
        System.out.println(requestModel.getMarriageStateOP());
        requestModel.setAreaOfInterestOp(this.userAnswer.get(5));
        System.out.println(requestModel.getAreaOfInterestOp());
        requestModel.setRelationshipOp(this.userAnswer.get(6));
        System.out.println(requestModel.getRelationshipOp());
        requestModel.setPetOp(this.userAnswer.get(7));
        System.out.println(requestModel.getPetOp());
    }


    /**
     * This method create a new searchInteractor and calls the method
     * to generate the list based on the answer user enters.
     *
     */
    public void generateRecommendation(){
        this.interactor.recommendListGenerator(requestModel);
    }
}
