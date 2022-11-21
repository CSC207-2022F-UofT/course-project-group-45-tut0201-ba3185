package controller;

import UI.SearchQuestionPanelInterface;
import use_case_discovery.SearchQuestionRequestModel;
import use_case_discovery.SearchAsker;
import use_case_discovery.SearchAskerInputBoundary;

public class FinderController {
    private int userOption;

    SearchQuestionPanelInterface panel;
    SearchQuestionRequestModel model;

    public FinderController(int userOption, SearchQuestionPanelInterface panel){
        this.userOption = userOption;
        this.panel = panel;
    }

    public void optionControl(){
        switch (userOption){
            //case 1:
            //   PreferencesFinder preferencesFinder = new PreferencesFinder();
            //    preferenceFinder.recommendListGenerator();
            //    break;

            //case 2:
            //    LocationFinder locationFinder = new LocationFinder();
            //    locationFinder.recommendListGenerator();
            //    break;

            case 3:
                model.setPanel(panel);
                SearchAskerInputBoundary searchAsker = new SearchAsker(model);
                searchAsker.generateQuestion();
                break;
        }
    }
}
