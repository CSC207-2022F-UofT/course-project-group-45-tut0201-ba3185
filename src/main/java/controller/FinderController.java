package controller;

import UI.SearchQuestionPanelInterface;
import use_case_discovery.SearchAsker;
import use_case_discovery.SearchAskerInputBoundary;

public class FinderController {
    private int userOption;
    // private SearchAskerInputBoundary searchAsker;
    SearchQuestionPanelInterface panel;

    public FinderController(int userOption, SearchQuestionPanelInterface panel){
        this.userOption = userOption;
        this.panel = panel;
        // this.searchAsker = searchAsker;
    }

    public void optionControl(){
        switch (userOption){
            //case 1:
            //   PreferencesFinder preferencesFinder = new PreferencesFinder();
            //    preferenceFinder.recommendListGenerator();
            //    break;

            //case 2:
            //    LocationFinder locationFinder = new LocationFinder();
            //    locationFinder.getNearbyUser();
            //    break;

            case 3:
                SearchAskerInputBoundary searchAsker = new SearchAsker(panel);
                searchAsker.generateQuestion();
                break;
        }
    }
}
