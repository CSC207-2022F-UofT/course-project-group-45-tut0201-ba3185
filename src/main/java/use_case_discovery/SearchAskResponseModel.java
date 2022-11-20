package use_case_discovery;

import java.util.ArrayList;

public class SearchAskResponseModel {
    private ArrayList<String> searchQuestion;

    public void setSearchQuestion(ArrayList<String> searchQuestion){this.searchQuestion = searchQuestion;}

    public ArrayList<String> getSearchQuestion(){return searchQuestion;}
}