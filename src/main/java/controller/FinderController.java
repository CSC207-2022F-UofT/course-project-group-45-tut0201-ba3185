package controller;

import gui.SearchQuestionPanelInterface;
import use_case_discovery.SearchQuestionRequestModel;
import use_case_discovery.SearchAsker;
import use_case_discovery.SearchAskerInputBoundary;

public class FinderController {
    private int userOption;

    SearchQuestionPanelInterface panel;
    SearchQuestionRequestModel model = new SearchQuestionRequestModel();

    public FinderController(int userOption, SearchQuestionPanelInterface panel){
        this.userOption = userOption;
        this.panel = panel;
    }

    /**
     * This method use the discovery option user enter to call the matching
     * finder which generate the list according to the option.
     *
     *
     */

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
