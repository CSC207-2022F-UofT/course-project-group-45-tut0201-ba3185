package controller;


import use_case_discovery.SearchAsker;
import use_case_discovery.SearchAskerInputBoundary;

import java.util.prefs.Preferences;

public class FinderController {
    private int userOption;
    private SearchAskerInputBoundary searchAsker;

    public FinderController(int userOption, SearchAskerInputBoundary searchAsker){
        this.userOption = userOption;
        this.searchAsker = searchAsker;
    }

    public void optionControl(){
        switch (userOption){
            case 1:
                PreferencesFinder preferencesFinder = new PreferencesFinder();
                preferenceFinder.recommendListGenerator();
                break;

            case 2:
                LocationFinder locationFinder = new LocationFinder();
                locationFinder.getNearbyUser();
                break;

            case 3:
                searchAsker.generateQuestion();
                break;
        }
    }
}
