package use_case_discovery;

import gui.SearchQuestionPanelInterface;
import presenter.SearchPresenter;

import java.util.ArrayList;

public class SearchAsker implements SearchAskerInputBoundary {
    private SearchAskerOutputBoundary presenter;
    private SearchAskResponseModel responseModel;

    private SearchQuestionRequestModel model;

    private SearchQuestionPanelInterface panel;

    public SearchAsker(SearchQuestionRequestModel model){
        this.model = model;
        this.responseModel = new SearchAskResponseModel();
    }

    public void generateQuestion(){
        this.responseModel = new SearchAskResponseModel();


        ArrayList<String> question_list = new ArrayList<>();
        // ask about the income
        question_list.add("Range of Income (in unit of k)"); // 1
        question_list.add("Range of Age(0-100)");// 2
        question_list.add("What marriage status are you looking for?");//3
        question_list.add("Single,Divorce,Married");//4
        question_list.add("What are the hobbies you want them to have?"); //5
        question_list.add("Sport,Art,Music,Game,Movie,Cook,Read");//6
        question_list.add("Which type of relationship are you looking for?");//7
        question_list.add("Friend,One-Night,Long-term,Short-term,Doesn't Care");//8
        question_list.add("Do you want them to have pet?"); //9
        question_list.add("Yes,No,Doesn't Care");//10

        responseModel.setSearchQuestion(question_list);
        panel = model.getPanel();
        responseModel.setPanel(panel);
        this.presenter = new SearchPresenter(responseModel);
        presenter.splitQuestion();

    }
}

