package use_case_discovery;

import UI.SearchQuestionPanelInterface;

import java.util.ArrayList;

public class SearchAskResponseModel {
    private ArrayList<String> searchQuestion;
    private SearchQuestionPanelInterface panel;

    public void setSearchQuestion(ArrayList<String> searchQuestion){this.searchQuestion = searchQuestion;}

    public ArrayList<String> getSearchQuestion(){return searchQuestion;}

    public void setPanel(SearchQuestionPanelInterface panel){
        this.panel = panel;
    }

    public SearchQuestionPanelInterface getPanel(){
        return panel;
    }

}