package use_case_discovery;

import UI.SearchQuestionPanelInterface;
import presenter.SearchPresenter;

import java.util.ArrayList;


public class SearchAsker implements SearchAskerInputBoundary {
    public SearchAskerOutputBoundary presenter;
    //private SearchPresenter;
    private SearchAskResponseModel responseModel;

    private SearchQuestionPanelInterface panel;

    public SearchAsker(SearchQuestionPanelInterface panel){
        //this.presenter = presenter;
        this.panel = panel;
    }

    public void generateQuestion(){
        this.responseModel = new SearchAskResponseModel();


        ArrayList<String> question_list = new ArrayList<>();
        // ask about the income
        question_list.add("What is the range of income you are looking for?(in unit of k)"); // 1
        question_list.add("What is the range of age you are looking for?(0-100)");// 2
        question_list.add("What marriage status are you looking for?");//3
        question_list.add("Single,Divorce,Married");//4
        question_list.add("What are the hobbies you want them to have?"); //5
        question_list.add("Sport,Art,Music,Game,Movie,Cook,Read");//6
        question_list.add("Which type of relationship are you looking for?");//7
        question_list.add("Friend,One-Night,Long-term,Short-term,Doesn't Care");//8
        question_list.add("Do you want them to have pet?"); //9
        question_list.add("Yes,No,Doesn't Care");//10

        responseModel.setSearchQuestion(question_list);
        this.presenter = new SearchPresenter(panel,responseModel);
        presenter.displayQuestion();

    }
}

